# Tugas 2 Praktikum Pemrograman Berorientasi Objek

**Materi:** Inheritance, Composition, dan Polimorfisme  
**Bahasa:** Java  
**Struktur package:** `soal1`, `soal2`, `soal3`, dan `soal4`

## Deskripsi

Project ini berisi empat latihan Praktikum Pemrograman Berorientasi Objek. Soal 1 membahas inheritance dan constructor subclass, Soal 2 membahas urutan constructor serta polimorfisme, Soal 3 membahas composition dan defensive copy, sedangkan Soal 4 menggabungkan inheritance, composition, polymorphism, downcasting aman, dan exception handling.

## Struktur Project

```text
Tugas2_Inherit-polymorph-25116/
├── src/
│   ├── soal1/
│   ├── soal2/
│   ├── soal3/
│   └── soal4/
├── README.md
└── .gitignore
```

## Cara Kompilasi dan Menjalankan

Jalankan perintah berikut dari direktori utama project menggunakan PowerShell.

```powershell
# Kompilasi seluruh source code
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName

# Jalankan pengujian masing-masing soal
java -cp out soal1.TesSoal1
java -cp out soal2.TesSoal2
java -cp out soal2.TesBagianB
java -cp out soal2.TesBagianC
java -cp out soal3.TesSoal3
java -cp out soal4.TesSoal4
```

Jika nama kelas pengujian di project berbeda, sesuaikan nama kelas pada perintah `java`.

---

## Jawaban Soal 1 – Hierarki Perangkat Elektronik

### Pertanyaan tambahan: perubahan `harga` menjadi `private`

Jika atribut `harga` pada kelas `Perangkat` diubah dari `protected` menjadi `private`, pemanggilan atribut tersebut secara langsung dari kelas `Laptop` tidak dapat diakses. Hal ini menyebabkan compilation error karena atribut `private` hanya bisa diakses dari dalam kelas tempat atribut tersebut dideklarasikan. Pada tugas ini, method `hitungHargaPromo()` di `Laptop` memang diminta mengakses `harga` secara langsung, sehingga akses `protected` diperlukan. Pesan error umumnya menyebutkan bahwa `harga` memiliki akses `private` di kelas `Perangkat` (nomor baris dan format pesan dapat berbeda tergantung compiler).

Contoh pesan error yang mungkin muncul:

```text
harga has private access in Perangkat
```

## Jawaban Soal 2 – Analisis Output, Error, dan Polimorfisme

### Bagian A

**1. Output program sampai program berhenti**

```text
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException:
class soal2.Hewan cannot be cast to class soal2.Kucing
```

Baris detail stack trace setelah pesan exception dapat berbeda tergantung lokasi file dan nomor baris. Program berhenti ketika objek `Hewan` dipaksa diubah menjadi `Kucing`.

**2. Jika `h.panjat()` diaktifkan**

Error terjadi pada tahap kompilasi, bukan runtime. Variabel `h` memiliki tipe statis `Hewan`, sedangkan method `panjat()` hanya tersedia di kelas `Kucing`. Compiler memeriksa method berdasarkan tipe statis variabel, sehingga pemanggilan `h.panjat()` tidak dikenali.

**3. Baris yang menyebabkan `ClassCastException` dan perbaikannya**

Baris yang bermasalah adalah:

```java
Kucing k2 = (Kucing) h2;
```

Objek yang sebenarnya disimpan dalam `h2` adalah objek `Hewan`, bukan `Kucing`. Pengecekan yang aman dapat dilakukan dengan `instanceof`:

```java
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println("h2 bukan objek Kucing");
}
```

**4. Method `suara()` yang dijalankan pada `h.makan()`**

Method `makan()` memang ditulis di kelas `Hewan`, tetapi pemanggilan `suara()` di dalamnya mengikuti objek yang sedang digunakan. Variabel `h` memiliki tipe statis `Hewan`, sedangkan tipe dinamis objeknya adalah `Kucing`. Karena `Kucing` melakukan overriding terhadap `suara()`, maka method `suara()` milik `Kucing` yang dijalankan dan menghasilkan tulisan `meong`. Ini merupakan contoh polimorfisme saat runtime.

### Bagian B

**5. Prediksi output dan penjelasan**

Output:

```text
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

Constructor kelas `A` dijalankan lebih dahulu ketika objek `B` dibuat. Constructor `A` memanggil method `init()` yang sudah dioverride oleh kelas `B`, sehingga method milik `B` dijalankan. Namun, atribut `nilai` milik `B` belum selesai diinisialisasi ketika pemanggilan tersebut terjadi, sehingga nilainya masih `0`. Memanggil method yang dapat dioverride dari constructor berisiko karena method subclass bisa dijalankan sebelum kondisi objek subclass siap.

### Bagian C

**6. Alasan `l3.luas()` menghasilkan `0.0` dan hubungan is-a**

Walaupun variabel `l3` bertipe `Lingkaran`, objek yang dibuat sebenarnya adalah `new Titik()`. Dalam Java, method yang dijalankan ditentukan oleh tipe dinamis objek, sehingga method `luas()` milik `Titik` yang menghasilkan `0.0` akan dipanggil. Hubungan “Titik adalah sebuah Lingkaran” tidak tepat karena titik tidak mempunyai sifat dan perilaku lingkaran. Jika sebuah method membutuhkan objek `Lingkaran` yang selalu memiliki luas lebih dari nol, objek `Titik` dapat menghasilkan perilaku yang tidak sesuai harapan. Ini menunjukkan bahwa inheritance harus digunakan ketika hubungan is-a memang masuk akal.

## Jawaban Soal 3 – Titik dan Garis

**1. Output sebelum defensive copy**

```text
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(100.0, 1.0) - (5.0, 5.0)
```

Sebelum diperbaiki, `Garis` menyimpan referensi langsung ke objek `Titik` dari luar. Ketika `t.setX(100)` dipanggil, titik yang tersimpan sebagai titik awal pada `g2` ikut berubah karena keduanya menunjuk objek yang sama. Kondisi ini disebut aliasing.

**2. Output setelah defensive copy**

```text
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(1.0, 1.0) - (5.0, 5.0)
```

Setelah defensive copy diterapkan, constructor `Garis` membuat objek `Titik` baru berdasarkan koordinat yang diterima. Perubahan pada objek `t` dari luar tidak lagi mengubah titik yang disimpan di dalam `Garis`. Dengan demikian, data internal `Garis` lebih terlindungi.

**3. Kapan aliasing dan defensive copy lebih tepat digunakan?**

Aliasing dapat digunakan ketika beberapa bagian program memang perlu berbagi dan melihat perubahan pada objek yang sama. Contohnya adalah data bersama yang harus selalu diperbarui oleh beberapa bagian program. Defensive copy lebih tepat ketika sebuah kelas perlu menjaga data internalnya agar tidak berubah tanpa kendali dari luar. Pada kelas `Garis`, defensive copy dipilih agar koordinat titik awal dan akhir tidak berubah hanya karena objek `Titik` dari luar dimodifikasi.

**4. Masalah jika `Garis` dibuat dengan `extends Titik`**

Jika `Garis` mewarisi `Titik`, hubungan yang terbentuk berarti “Garis adalah sebuah Titik”. Hubungan tersebut tidak sesuai karena garis bukan titik, melainkan objek yang tersusun dari dua titik. Desain yang tepat adalah composition atau has-a, yaitu `Garis` memiliki titik awal dan titik akhir. Dengan composition, tanggung jawab setiap kelas menjadi lebih jelas dan sesuai dengan konsep objek sebenarnya.

## Bagian Analisis Konsep

**1. Perbedaan method overriding dan method overloading**

Overriding adalah penulisan ulang method dari superclass oleh subclass dengan nama dan parameter yang sama. Contohnya adalah method `infoSingkat()` pada kelas `Laptop` yang meng-override method dari `Perangkat`, serta `hitungHargaAkhir()` pada kelas produk di Soal 4. Overloading adalah pembuatan beberapa method atau constructor dengan nama sama tetapi parameter berbeda. Contohnya terdapat pada dua constructor kelas `Garis`, yaitu constructor yang menerima dua objek `Titik` dan constructor yang menerima empat nilai koordinat. Overriding berkaitan dengan inheritance dan polimorfisme runtime, sedangkan overloading memungkinkan pemanggilan berdasarkan parameter yang diberikan.

**2. Kapan memilih inheritance dan composition?**

Inheritance dipilih ketika terdapat hubungan is-a, yaitu suatu subclass benar-benar merupakan jenis dari superclass. Contohnya `Laptop` merupakan `Perangkat`, dan `ProdukFisik` merupakan `Produk`. Composition dipilih ketika suatu objek tersusun dari atau memiliki objek lain, sehingga hubungannya adalah has-a. Contohnya kelas `Garis` memiliki dua objek `Titik`, sedangkan `Keranjang` memiliki daftar objek `Produk`. Pemilihan hubungan yang tepat membuat struktur program lebih mudah dipahami dan dikembangkan.

**3. Mengapa `cetakStruk()` tidak memerlukan `instanceof`, sedangkan `hitungPerJenis()` memerlukannya?**

Method `cetakStruk()` tidak memerlukan `instanceof` karena semua objek di dalam keranjang memiliki method `hitungHargaAkhir()` dan `deskripsi()` yang dapat dipanggil melalui tipe superclass `Produk`. Setiap subclass memberikan implementasi masing-masing melalui overriding, sehingga polimorfisme menentukan method yang dijalankan. Sementara itu, `hitungPerJenis()` perlu mengetahui jenis objek secara spesifik untuk menghitung jumlah produk fisik, digital, dan langganan. Karena itu, method tersebut menggunakan `instanceof` sebelum melakukan downcasting. Downcasting tidak selalu aman karena objek yang sebenarnya belum tentu merupakan instance dari subclass yang dituju, sehingga cast yang salah dapat menyebabkan `ClassCastException`.

---

## Hasil Pengujian Soal 4

Output pengujian:

```text
F01 | Keyboard Mekanik | fisik 1.5 kg | Rp515000
D01 | Ebook Java | digital 20.0 MB | Rp90000
L01 | Kelas Online | langganan 12 bulan | Rp1440000
TOTAL: Rp2045000
Fisik: 1, Digital: 1, Langganan: 1
Gagal: Kode produk sudah ada: F01
```

Hasil tersebut menunjukkan bahwa perhitungan harga, diskon, komposisi keranjang, polimorfisme, penghitungan jenis produk, dan penanganan kode produk duplikat berjalan sesuai pengujian.

## Catatan Pengumpulan

- Source code Java diletakkan di folder `src` dengan package terpisah untuk setiap soal.
- Sertakan screenshot hasil program yang benar-benar dijalankan dari komputer sendiri.
- Sertakan file README ini dan `.gitignore`.
- Jangan sertakan file hasil kompilasi `.class` atau folder `out` ke repository.
- Kumpulkan tautan repository GitHub dan berkas ZIP project sesuai instruksi praktikum.
