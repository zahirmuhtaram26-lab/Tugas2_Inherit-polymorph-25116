package soal1;

/**
 * Kelas laptop gaming yang merupakan turunan Laptop.
 */
public class LaptopGaming extends Laptop {

    private String kartuGrafis;

    public LaptopGaming(String merek, double harga, int garansiBulan,
                        int ramGb, double ukuranLayarInci,
                        String kartuGrafis) {
        super(merek, harga, garansiBulan, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat()
                + " | GPU " + kartuGrafis;
    }
}
