package soal1;

/**
 * Program untuk menguji inheritance perangkat elektronik.
 */
public class TesSoal1 {

    public static void main(String[] args) {

        Perangkat perangkat = new Perangkat(
                "Samsung", 3000000, 12);

        Laptop laptop = new Laptop(
                "Asus", 12000000, 24, 16, 15.6);

        Ponsel ponsel = new Ponsel(
                "Xiaomi", 4000000, 12, 5000, 3);

        LaptopGaming gaming = new LaptopGaming(
                "ROG", 20000000, 24, 32, 16,
                "RTX 4060");

        System.out.println(perangkat.infoSingkat());
        System.out.println(laptop.infoSingkat());
        System.out.println(ponsel.infoSingkat());
        System.out.println(gaming.infoSingkat());

        System.out.println("Pajak laptop: "
                + laptop.hitungPajak());

        System.out.println("Harga promo laptop: "
                + laptop.hitungHargaPromo(10));
    }
}
