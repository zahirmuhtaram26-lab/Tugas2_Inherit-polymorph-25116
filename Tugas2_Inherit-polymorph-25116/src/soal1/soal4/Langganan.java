package soal4;

public class Langganan extends ProdukDigital {

    private int durasiBulan;

    public static final double DISKON_LANGGANAN = 0.20;
    public static final int BATAS_DISKON_BULAN = 12;

    public Langganan(String kode, String nama, double hargaDasar,
                     double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);

        if (durasiBulan <= 0) {
            throw new IllegalArgumentException("Durasi harus lebih dari 0");
        }

        this.durasiBulan = durasiBulan;
    }

    @Override
    public double hitungHargaAkhir() {
        double total = hargaDasar * durasiBulan;

        if (durasiBulan >= BATAS_DISKON_BULAN) {
            total = total * (1 - DISKON_LANGGANAN);
        }

        return total;
    }

    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }
}