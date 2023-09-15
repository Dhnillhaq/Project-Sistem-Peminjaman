package Tampilan;
/*
 *  Deskripsi:
 *          Di MeminjamBuku.java ini kita membuat suatu program yang mempunyai aksi
 *      1. [Output] Menampilkan Daftar Buku Beserta Stok Masing2 Buku
 *      2. [Input ] Memilih Salah Satu Buku Untuk Dipinjam
 *      3. [Input ] Memberikan Input Jumlah Buku yang Akan Dipinjam
 *      4. [Output] Menampilkan Daftar Buku Beserta Stok masing2 Buku Setelah Dipinjam
 *      5. Selesai
 */

import java.util.Scanner;

public class MeminjamBuku {
    
    public void meminjamBuku() {

        // Deklarasi Scanner untuk input 
        Scanner input = new Scanner(System.in);

        // Deklarasi stok buku akademik
        int stokBukuNonAkademik = 10;

        // Sambutan
        System.out.println("---------------------------------");
        System.out.println("SELAMAT DATANG DI PEMINJAMAN BUKU\n");

        // User menentukan jumlah peminjaman buku
        System.out.println("[stok "+stokBukuNonAkademik+"]\nBuku Non-Akademik\n");
        System.out.print("Jumlah buku yang ingin dipinjam?\n$> ");
        int pilihBuku = input.nextInt();

        // Melakukan pengurangan 
        stokBukuNonAkademik -= pilihBuku;

        // Menampilkan hasil dari peminjaman
        System.out.println("\n[stok "+stokBukuNonAkademik+"]\nBuku Non-Akademik\n");

    }

}
