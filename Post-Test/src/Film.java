class Film {
    String kodeFilm;
    String judul;
    int harga;

    Film(String kodeFilm, String judul, int harga) {
        this.kodeFilm = kodeFilm;
        this.judul = judul;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Kode Film: " + kodeFilm + ", Judul: " + judul + ", Harga: Rp " + harga;
    }
}
