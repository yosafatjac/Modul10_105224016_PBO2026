public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        // Daftarkan minimal 3 barang baru
        gudang.tambahBarangBaru("A1", "Laptop", "Elektronik", 10);
        gudang.tambahBarangBaru("A2", "Meja", "Furniture", 15);
        gudang.tambahBarangBaru("A3", "Pulpen", "ATK", 50);

        // 1x tambah stok berhasil
        gudang.tambahStok("A1", 5);

        // 1x kurangi stok berhasil
        gudang.kurangiStok("A2", 3);

        // 1x kurangi stok gagal karena stok tidak cukup
        gudang.kurangiStok("A3", 100);

        // Cetak laporan akhir
        gudang.cetakLaporan();
    }
}