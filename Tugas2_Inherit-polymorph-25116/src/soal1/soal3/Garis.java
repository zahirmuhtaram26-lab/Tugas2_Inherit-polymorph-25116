
package soal3;

/**
 * Kelas Garis yang memiliki dua objek Titik.
 */
public class Garis {

    private Titik awal;
    private Titik akhir;

    // Constructor menggunakan defensive copy
    public Garis(Titik awal, Titik akhir) {
        this.awal = new Titik(awal.getX(), awal.getY());
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    // Constructor overloading menggunakan koordinat
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    public Titik getAwal() {
        return new Titik(awal.getX(), awal.getY());
    }

    public void setAwal(Titik awal) {
        this.awal = new Titik(awal.getX(), awal.getY());
    }

    public Titik getAkhir() {
        return new Titik(akhir.getX(), akhir.getY());
    }

    public void setAkhir(Titik akhir) {
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}
