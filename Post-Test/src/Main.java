import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Kita menyimpan jadwal film menggunakan Map
        Map<String, Film> jadwalFilm = new HashMap<>();

        jadwalFilm.put("F01", new Film("F01", "Avengers: Endgame", 50000));
        jadwalFilm.put("F02", new Film("F02", "Interstellar", 45000));
        jadwalFilm.put("F03", new Film("F03", "Jumbo", 40000));

        System.out.println("\nJadwal Film Hari Ini");
        for (Film film : jadwalFilm.values()) {
            System.out.println(film);
        }

        // Kita menyimpan kursi yang sudah dipesan menggunakan Set
        Set<String> kursiDipesan = new HashSet<>();

        // Menyimpan riwayat transaksi sukses menggunakan List
        List<Transaksi> riwayatTransaksi = new ArrayList<>();

        System.out.println("\nProses Pemesanan Tiket");

        // Minimal 3 pesanan sukses
        pesanTiket(jadwalFilm, kursiDipesan, riwayatTransaksi, "Yosafat", "F01", "A1");
        pesanTiket(jadwalFilm, kursiDipesan, riwayatTransaksi, "Dwi", "F02", "A2");
        pesanTiket(jadwalFilm, kursiDipesan, riwayatTransaksi, "Pradana", "F03", "A3");

        // 1 pesanan gagal karena kursi ganda
        pesanTiket(jadwalFilm, kursiDipesan, riwayatTransaksi, "Michael", "F01", "A1");

        // Contoh gagal karena kode film tidak valid
        pesanTiket(jadwalFilm, kursiDipesan, riwayatTransaksi, "Rafly", "F99", "B1");

        System.out.println("\nRiwayat Transaksi Sukses");
        for (Transaksi transaksi : riwayatTransaksi) {
            System.out.println(transaksi);
        }
    }

    static void pesanTiket(
            Map<String, Film> jadwalFilm,
            Set<String> kursiDipesan,
            List<Transaksi> riwayatTransaksi,
            String namaPemesan,
            String kodeFilm,
            String nomorKursi
    ) {
        if (!jadwalFilm.containsKey(kodeFilm)) {
            System.out.println(namaPemesan + " gagal memesan: kode film tidak valid");
            return;
        }

        if (kursiDipesan.contains(nomorKursi)) {
            System.out.println(namaPemesan + " gagal memesan: kursi " + nomorKursi + " sudah dipesan");
            return;
        }

        Film film = jadwalFilm.get(kodeFilm);

        kursiDipesan.add(nomorKursi);
        riwayatTransaksi.add(new Transaksi(namaPemesan, film, nomorKursi));

        System.out.println(namaPemesan + " berhasil memesan " + film.judul + " kursi " + nomorKursi);
    }
}