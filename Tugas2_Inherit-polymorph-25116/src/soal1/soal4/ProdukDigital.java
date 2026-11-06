package soal4;

public class ProdukDigital extends Produk {

    protected double ukuranMb;

    public static final double DISKON_DIGITAL = 0.10;

    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);

        if (ukuranMb < 0) {
            throw new IllegalArgumentException("Ukuran tidak boleh negatif");
        }

        this.ukuranMb = ukuranMb;
    }

    @Override
    public double hitungHargaAkhir() {
        return hargaDasar * (1 - DISKON_DIGITAL);
    }

    @Override
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }
}
