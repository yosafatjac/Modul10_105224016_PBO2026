import java.util.*;

public class SistemGudang {
    private Map<String, Barang> databaseBarang = new LinkedHashMap<>();
    private Set<String> kategoriUnik = new LinkedHashSet<>();
    private List<String> riwayat = new ArrayList<>();

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        if (databaseBarang.containsKey(id)) {
            System.out.println("Gagal: ID barang sudah terdaftar.");
            return;
        }

        Barang barang = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);

        riwayat.add("Barang Baru: " + id + " - " + nama + " ditambahkan dengan stok " + stok);
        System.out.println("Berhasil menambahkan barang: " + nama);
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);

        if (barang == null) {
            System.out.println("Gagal: ID barang tidak ditemukan.");
            return;
        }

        barang.tambahStok(jumlah);
        riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit");
        System.out.println("Berhasil menambah stok barang: " + barang.getNamaBarang());
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);

        if (barang == null) {
            System.out.println("Gagal: ID barang tidak ditemukan.");
            return;
        }

        if (barang.kurangiStok(jumlah)) {
            riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit");
            System.out.println("Berhasil mengurangi stok barang: " + barang.getNamaBarang());
        } else {
            riwayat.add("Gagal Keluar: " + id + " gagal dikurangi " + jumlah + " unit karena stok tidak cukup");
            System.out.println("Gagal: stok tidak mencukupi.");
        }
    }

    public void cetakLaporan() {
        System.out.println("\n===== Laporan Gudang =====");

        System.out.println("\nDaftar Kategori:");
        for (String kategori : kategoriUnik) {
            System.out.println("- " + kategori);
        }

        System.out.println("\nDaftar Barang:");
        for (Barang barang : databaseBarang.values()) {
            System.out.println(
                barang.getIdBarang() + " | " +
                barang.getNamaBarang() + " | " +
                barang.getKategori() + " | Stok: " +
                barang.getStok()
            );
        }

        System.out.println("\nRiwayat Transaksi:");
        for (String aktivitas : riwayat) {
            System.out.println("- " + aktivitas);
        }
    }
}