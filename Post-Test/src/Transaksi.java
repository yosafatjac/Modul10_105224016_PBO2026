class Transaksi {
    String namaPemesan;
    Film film;
    String nomorKursi;

    Transaksi(String namaPemesan, Film film, String nomorKursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.nomorKursi = nomorKursi;
    }

    @Override
    public String toString() {
        return "Nama Pemesan: " + namaPemesan +
                ", Judul Film: " + film.judul +
                ", Nomor Kursi: " + nomorKursi +
                ", Harga: Rp " + film.harga;
    }
}