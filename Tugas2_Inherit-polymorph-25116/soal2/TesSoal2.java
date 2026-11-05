package soal2;

public class TesSoal2 {
    public static void main(String[] args) {

        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();

        // h.panjat();

        Kucing k = (Kucing) h;
        k.panjat();

        Hewan h2 = new Hewan("Generik");

        // Perbaikan menggunakan instanceof
        if (h2 instanceof Kucing) {
            Kucing k2 = (Kucing) h2;
            k2.panjat();
        } else {
            System.out.println("h2 bukan objek Kucing");
        }
    }
}