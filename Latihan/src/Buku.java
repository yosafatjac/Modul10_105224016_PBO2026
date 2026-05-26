class Buku {

    String isbn;
    String judul;

    Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
}

@Override
public String toString() {
    return "ISBN: " + isbn + ", Judul: " + judul;
    }
}
