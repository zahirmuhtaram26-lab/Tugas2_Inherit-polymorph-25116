package soal3;

public class Garis {
    private Titik awal;
    private Titik akhir;

    // Constructor dengan objek Titik
    public Garis(Titik awal, Titik akhir) {
        this.awal = awal;
        this.akhir = akhir;
    }

    // Constructor overloading dengan koordinat
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    public Titik getAwal() {
        return awal;
    }

    public void setAwal(Titik awal) {
        this.awal = awal;
    }

    public Titik getAkhir() {
        return akhir;
    }

    public void setAkhir(Titik akhir) {
        this.akhir = akhir;
    }

    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}