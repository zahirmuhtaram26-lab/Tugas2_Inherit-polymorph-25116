package soal2;

public class Kucing extends Hewan {

    public Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    @Override
    void suara() {
        System.out.println("meong");
    }

    void panjat() {
        System.out.println(nama + " memanjat");
    }
}