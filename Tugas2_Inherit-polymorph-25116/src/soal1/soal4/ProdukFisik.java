package soal4;

public class ProdukFisik extends Produk {

    private double beratKg;

    public static final double ONGKOS_KIRIM_PER_KG = 10000;

    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);

        if (beratKg < 0) {
            throw new IllegalArgumentException("Berat tidak boleh negatif");
        }

        this.beratKg = beratKg;
    }

    @Override
    public double hitungHargaAkhir() {
        return hargaDasar + (beratKg * ONGKOS_KIRIM_PER_KG);
    }

    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }
}