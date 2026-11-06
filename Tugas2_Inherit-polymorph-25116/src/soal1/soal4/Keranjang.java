package soal4;

import java.util.ArrayList;

public class Keranjang {

    private ArrayList<Produk> daftarProduk = new ArrayList<>();

    public void tambah(Produk produk) {
        for (Produk p : daftarProduk) {
            if (p.getKode().equals(produk.getKode())) {
                throw new IllegalStateException(
                    "Kode produk sudah ada: " + produk.getKode()
                );
            }
        }

        daftarProduk.add(produk);
    }

    public double hitungTotal() {
        double total = 0;

        for (Produk p : daftarProduk) {
            total += p.hitungHargaAkhir();
        }

        return total;
    }

    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf(
                "%s | %s | %s | Rp%.0f%n",
                p.getKode(),
                p.getNama(),
                p.deskripsi(),
                p.hitungHargaAkhir()
            );
        }

        System.out.printf("TOTAL: Rp%.0f%n", hitungTotal());
    }

    public void hitungPerJenis() {
        int fisik = 0;
        int digital = 0;
        int langganan = 0;

        for (Produk p : daftarProduk) {
            if (p instanceof ProdukFisik) {
                ProdukFisik pf = (ProdukFisik) p;
                fisik++;
            } else if (p instanceof Langganan) {
                Langganan l = (Langganan) p;
                langganan++;
            } else if (p instanceof ProdukDigital) {
                ProdukDigital pd = (ProdukDigital) p;
                digital++;
            }
        }

        System.out.printf(
            "Fisik: %d, Digital: %d, Langganan: %d%n",
            fisik, digital, langganan
        );
    }
}