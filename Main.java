import java.util.Scanner;

import Tampilan.LoginRegister;          // Mengambil Class LoginRegister
import Tampilan.ManajemenBuku;          // Mengambil Class ManajemenBuku
import Tampilan.MeminjamBuku;           // Mengambil Class MeminjamBuku
import Tampilan.MeminjamBukuDigital;    // Mengambil Class MeminjamBukuDigital
import Tampilan.PencarianBuku;          // Mengambil Class PencarianBuku
import Tampilan.PengembalianBuku;       // Mengambil Class PengembalianBuku
/**
 *  Main
 *  Deskripsi:
 *  Sesuai dengan namanya, Main.java dibuat sebagai PROGRAM UTAMA dari beberapa file.
 *  Program ini digunakan untuk memanggil Class-class lain yang berada di luar Class Main ini.
 *  Sehingga program bisa dikumpulkan menjadi satu di Class Main ini.
 */
public class Main {

    public static void main(String[] args) {
        // Deklarasi Scanner untuk input
        Scanner input = new Scanner(System.in);

        // Deklarasi Variabel
        int pilihanInput;

        // Tampilan Menu 
        System.out.println("Selamat Datang di Perpustakaan! (Under Development)\n");

        System.out.println("1] Login/Register");
        System.out.println("2] Peminjaman Buku");
        System.out.println("3] Pengembalian Buku");
        System.out.println("4] Manajemen Buku");
        System.out.println("5] Pencarian Buku");
        System.out.println("6] Buku Digital");
        System.out.println("7] Pengelolaan Stok Buku");
        
        // Meminta input dari user
        System.out.println("\nSilahkan pilih salah satu dari menu diatas");
        System.out.print("$> ");
        pilihanInput = input.nextInt();
        System.out.println("");

        // Memilih sesuai dengan input user
        switch(pilihanInput){
            case 1:
                new LoginRegister();        // Menjalankan Class LoginRegister.java
                break;
            case 2:
                new MeminjamBuku().meminjamBuku();         // Menjalankan Class MeminjamBuku.java
                break;
            case 3:
                new PengembalianBuku();     // Menjalankan Class PengembalianBuku.java
                break;
            case 4:
                new ManajemenBuku();        // Menjalankan Class ManajemenBuku.java
                break;
            case 5:
                new PencarianBuku();        // Menjalankan Class PencarianBuku.java
                break;
            case 6:
                new MeminjamBukuDigital();  // Menjalankan Class MeminjamBukuDigital.java
                break;
            case 7:
                new ManajemenBuku();        // Menjalankan Class ManajemenBuku.java
                break;
            default:        // Kondisi jika inputan TIDAK SESUAI dengan menu apapun
                System.out.println("Maaf Input anda tidak sesuai, program keluar");
                break;
        }

    }

    

}