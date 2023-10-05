import java.util.Scanner;

/**
 * Main
 * Deskripsi:
 * Sesuai dengan namanya, Main.java dibuat sebagai PROGRAM UTAMA dari beberapa
 * file.
 * Program ini digunakan untuk memanggil Class-class lain yang berada di luar
 * Class Main ini.(On Progress)
 * Sehingga program bisa dikumpulkan menjadi satu di Class Main ini.
 */
public class Main {

    public static void main(String[] args) {
        // Deklarasi Scanner untuk input
        Scanner input = new Scanner(System.in);

        // Deklarasi Variabel
        // Variabel Pilih Menu dan Stok Buku
        int pilihanInput, stokBukuNonAkademik = 10;

        // Variabel inputan Username dan Password
        String username, password;

        // Variabel UI
        String separator = "\n\n-------------------------------------------------------";

        // Variabel data Username
        String storedUsername = "Admin";

        // Variabel data Password
        String storedPassword = "admin";

        // Variabel if true
        boolean canLogin = false;
        boolean exit = false;

        // WAJIB Login sebelum masuk
            System.out.println("Silahkan verifikasi diri anda terlebih dahulu\n");
            System.out.print("Username :");
            username = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            // Jika benar
            if (username.equals(storedUsername)) {
                if (password.equals(storedPassword))
                    canLogin = true;
            }
            // Jika salah
            else {
                System.out.println("\nMaaf, tidak ada Username dengan password tersebut");
            }

        if (canLogin) {
            // Tampilan Menu
            System.out.println("Selamat Datang di Perpustakaan! (Under Development)\n");

            System.out.println("1] Peminjaman Buku");
            System.out.println("2] Pengembalian Buku");
            System.out.println("3] Manajemen Buku");
            System.out.println("4] Pencarian Buku");
            System.out.println("5] Buku Digital");
            System.out.println("6] Pengelolaan Stok Buku");

            // Meminta input dari user
            System.out.println("\nSilahkan pilih salah satu dari menu diatas");
            System.out.print("$> ");
            pilihanInput = input.nextInt();

            // Memilih sesuai dengan input user
            switch (pilihanInput) {
                case 1:
                    //  -Peminjaman Buku
                    // Sambutan
            System.out.println();
            System.out.println("SELAMAT DATANG DI PEMINJAMAN BUKU\n");

            // User menentukan jumlah peminjaman buku
            System.out.println("[stok " + stokBukuNonAkademik + "]\nBuku Non-Akademik\n");
            System.out.print("Jumlah buku yang ingin dipinjam?\n$> ");
            int pilihBuku = input.nextInt();

            // Melakukan pengurangan
            stokBukuNonAkademik -= pilihBuku;

            // Menampilkan hasil dari peminjaman
            System.out.println("\n[stok " + stokBukuNonAkademik + "]\nBuku Non-Akademik\n");
                    break;
                case 2:
                    //  -Pengembalian Buku
                      // *Isi dari Method

                    break;
                case 3:
                    //  -Manajemen Buku
                      // *Isi dari Method

                    break;
                case 4:
                    //  -Pencarian Buku
                      // *Isi dari Method

                    break;
                case 5:
                    //  -Meminjam Buku Digital
                      // *Isi dari Method

                    break;
                case 6:
                    //  -Mengelola Stok Buku
                      // *Isi dari Method

                    break;
                default: // Kondisi jika inputan TIDAK SESUAI dengan menu apapun
                    System.out.println("Maaf Input anda tidak sesuai, program keluar");
                    break;
            }
        } else {
            
        }

    }
    }