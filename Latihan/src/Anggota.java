class Anggota {

    String idAnggota;
    String nama;
    String tipe;

    Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Anggota)) return false;
        Anggota anggota = (Anggota) obj;
        return this.idAnggota.equals(anggota.idAnggota);
    }
    
    @Override
    public int hashCode() {
        return idAnggota.hashCode();
    
    }

    @Override
    public String toString() {
        return "ID Anggota: " + idAnggota + ", Nama: " + nama + ", Tipe: " + tipe;
    }

}