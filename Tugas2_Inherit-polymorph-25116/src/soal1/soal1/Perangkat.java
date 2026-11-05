
package soal1;

/**
 * Kelas dasar untuk perangkat elektronik.
 */
public class Perangkat {

    private String merek;
    protected double harga;
    private int garansiBulan;

    private static final double TARIF_PAJAK = 0.10;

    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong");
        }

        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }

        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    public String getMerek() {
        return merek;
    }

    public int getGaransiBulan() {
        return garansiBulan;
    }

    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}
