import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Soal 1
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("ISBN001", new Buku("ISBN001", "Buku Pemrograman Berorientasi Objek"));
        katalogBuku.put("ISBN002", new Buku("ISBN002", "Buku Algoritma dan Struktur Data"));
        katalogBuku.put("ISBN003", new Buku("ISBN003", "Buku Basis Data"));

        System.out.println("Katalog Buku:");
        System.out.println(katalogBuku.get("ISBN001"));

        // Soal 2
        Set<Anggota> daftarAnggota = new HashSet<>();

        daftarAnggota.add(new Anggota("A001", "Yosafat Jacobus", "Mahasiswa"));
        daftarAnggota.add(new Anggota("A002", "Pak Ade Irawan", "Dosen"));
        daftarAnggota.add(new Anggota("A003", "Pradana Akbar Razan", "Mahasiswa"));

        boolean berhasil = daftarAnggota.add(new Anggota("A001", "Yosafat Lagi", "Mahasiswa"));

        System.out.println("\nDaftar Anggota:");
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        System.out.println("\nApakah duplikat berhasil ditambahkan? " + berhasil);

        // Soal 3
        LinkedList<String> antrean = new LinkedList<>();

        tambahAntrean(antrean, "A001", "ISBN001", "Mahasiswa");
        tambahAntrean(antrean, "A002", "ISBN002", "Dosen");
        tambahAntrean(antrean, "A003", "ISBN003", "Mahasiswa");
        tambahAntrean(antrean, "A004", "ISBN001", "Dosen");

        System.out.println("\nAntrean Peminjaman:");
        for (String data : antrean) {
            System.out.println(data);
        }

        // Soal 4
        Set<String> bukuSedangDipinjam = new HashSet<>();

        System.out.println("\nProses Antrean:");

        while (!antrean.isEmpty()) {
            String data = antrean.removeFirst();

            String[] pecah = data.split("#");
            String idAnggota = pecah[0];
            String isbn = pecah[1];

            boolean anggotaAda = false;

            for (Anggota anggota : daftarAnggota) {
                if (anggota.idAnggota.equals(idAnggota)) {
                    anggotaAda = true;
                    break;
                }
            }

            if (!anggotaAda) {
                System.out.println(data + " gagal: idAnggota tidak terdaftar");
            } else if (!katalogBuku.containsKey(isbn)) {
                System.out.println(data + " gagal: ISBN tidak ada di katalog buku");
            } else if (bukuSedangDipinjam.contains(isbn)) {
                System.out.println(data + " gagal: buku sedang dipinjam");
            } else {
                bukuSedangDipinjam.add(isbn);
                System.out.println(data + " berhasil dipinjam");
            }
        }

        System.out.println("\nBuku Sedang Dipinjam:");
        for (String isbn : bukuSedangDipinjam) {
            System.out.println(katalogBuku.get(isbn));
        }
    
        // Soal 5
        List<Buku> laporanBukuDipinjam = new ArrayList<>();

        for (String isbn : bukuSedangDipinjam) {
            laporanBukuDipinjam.add(katalogBuku.get(isbn));
        }

        laporanBukuDipinjam.sort(Comparator.comparing(buku -> buku.judul));

        System.out.println("\nLaporan Buku Sedang Dipinjam A-Z:");
        for (Buku buku : laporanBukuDipinjam) {
            System.out.println(buku);
        }
    }

    static void tambahAntrean(LinkedList<String> antrean, String idAnggota, String isbn, String tipe) {
        String data = idAnggota + "#" + isbn;

        if (tipe.equalsIgnoreCase("Dosen")) {
            antrean.addFirst(data);
        } else {
            antrean.addLast(data);
        }
    }
}