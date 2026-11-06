
package soal1;

/**
 * Kelas untuk perangkat ponsel.
 */
public class Ponsel extends Perangkat {

    private int kapasitasBaterai;
    private int jumlahKamera;

    public Ponsel(String merek, double harga, int garansiBulan,
                  int kapasitasBaterai, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasBaterai = kapasitasBaterai;
        this.jumlahKamera = jumlahKamera;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat()
                + " | baterai " + kapasitasBaterai + " mAh"
                + " | kamera " + jumlahKamera;
    }
}
