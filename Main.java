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
        // Variabel Pilih Menu dan Stok Buku (Case 1)
        int pilihanInput, stokBukuNonAkademik = 10;
        int pilihBuku;
        

        // Variabel Nama, Jumlah Halaman dan Pengarang (Case 3)
        String namaBuku1 = "Malin Kundang";
        int jumlahHalBuku1 = 21;
        String pengarangBuku1 = "Dede Firmansyah";
        String namaBuku2, pengarangBuku2;
        int jumlahHalBuku2;
        char inputValidate;

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
        // boolean exit = false;

        // WAJIB Login sebelum masuk
        System.out.println("Silahkan verifikasi diri anda terlebih dahulu\n");
        System.out.print("Username: ");
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
            System.out.println(separator);
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
                    System.out.println(separator);
                    System.out.println("SELAMAT DATANG DI PEMINJAMAN BUKU\n");

                    // User menentukan jumlah peminjaman buku
                    System.out.println("[stok " + stokBukuNonAkademik + "]\nBuku Non-Akademik\n");
                    System.out.print("Jumlah buku yang ingin dipinjam?\n$> ");
                    pilihBuku = input.nextInt();

                    // Melakukan pengurangan
                    stokBukuNonAkademik -= pilihBuku;

                    // Menampilkan hasil dari peminjaman
                    System.out.println("\n[stok " + stokBukuNonAkademik + "]\nBuku Non-Akademik\n");
                    break;
                case 2:
                    //  -Pengembalian Buku
                      // *Isi dari case

                    break;
                case 3:
                    //  -Manajemen Buku
                    System.out.println(separator);
                    System.out.println("SELAMAT DATANG DI MANAJEMEN BUKU\n");

                    // Menampilkan list buku
                    System.out.println("#List Buku");
                    System.out.println("Nama Buku: "+namaBuku1);
                    System.out.println("Pengarang: "+pengarangBuku1);
                    System.out.println("Jumlah Halaman: "+jumlahHalBuku1);

                    // Menanyakan apakah ingin mengubah/menambahkan/menghapus buku?
                    System.out.println("\n1] Menambahkan Buku Baru\n2] Mengubah Buku\n3] Menghapus Buku\n0] Batalkan ");
                    System.out.print("\nApakah anda ingin melakukan sesuatu dengan data buku tersebut?\n$> ");
                    pilihanInput = input.nextInt();

                    // Switch Case jika memilih
                    switch(pilihanInput){
                        case 1:
                        input.nextLine();
                            System.out.println("\n---MENAMBAHKAN BUKU BARU---");
                            System.out.print("Nama Buku     : ");
                            namaBuku2 = input.nextLine();
                            System.out.print("Pengarang     : ");
                            pengarangBuku2 = input.nextLine();
                            System.out.print("Jumlah Halaman: ");
                            jumlahHalBuku2 = input.nextInt();

                            System.out.println("\nDATA BERHASIL DITAMBAHKAN!\n");

                            // Menampilkan list buku
                            System.out.println("#List Buku");
                            System.out.println("Nama Buku       : "+namaBuku1);
                            System.out.println("Pengarang       : "+pengarangBuku1);
                            System.out.println("Jumlah Halaman  : "+jumlahHalBuku1);
                            System.out.println();
                            System.out.println("Nama Buku       : "+namaBuku2+" (New Added)");
                            System.out.println("Pengarang       : "+pengarangBuku2);
                            System.out.println("Jumlah Halaman  : "+jumlahHalBuku2);
                            System.out.println();
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("\n---MENGUBAH BUKU---");
                            System.out.print("Nama Buku     : ");
                            namaBuku1 = input.nextLine();
                            System.out.print("Pengarang     : ");
                            pengarangBuku1 = input.nextLine();
                            System.out.print("Jumlah Halaman: ");
                            jumlahHalBuku1 = input.nextInt();

                            System.out.println("\nDATA BERHASIL DIUBAH\n");

                            // Menampilkan list buku
                            System.out.println("#List Buku");
                            System.out.println("Nama Buku       : "+namaBuku1);
                            System.out.println("Pengarang       : "+pengarangBuku1);
                            System.out.println("Jumlah Halaman  : "+jumlahHalBuku1);
                            System.out.println();
                            break;
                        case 3:
                            input.nextLine();
                            System.out.print("\nApakah anda yakin untuk menghapus data diatas? (Y/n)\n$> ");
                            inputValidate = input.nextLine().charAt(0);

                            if (inputValidate != 'y' && inputValidate != 'Y') {
                                System.out.println("\nAnda membatalkan penghapusan data..");
                                return;
                            } 
                            
                            namaBuku1 = "";
                            pengarangBuku1 = "";
                            jumlahHalBuku1 = 0;

                            // Menampilkan list buku
                            System.out.println("#List Buku (Tidak tersedia)");
                            System.out.println("Nama Buku       : (kosong)");
                            System.out.println("Pengarang       : (kosong)");
                            System.out.println("Jumlah Halaman  : (kosong)");
                            System.out.println();

                            break;
                        case 0:
                            System.out.println("\nAnda membatalkan pemilihan...");
                            break;
                        default:
                    }


                    break;
                case 4:
                    //  -Pencarian Buku
                      // *Isi dari case

                    break;
                case 5:
                    //  -Meminjam Buku Digital
                      // *Isi dari case

                    break;
                case 6:
                    //  -Mengelola Stok Buku
                      // *Isi dari case

                    break;
                default: // Kondisi jika inputan TIDAK SESUAI dengan menu apapun
                    System.out.println("Maaf Input anda tidak sesuai, program keluar");
                    break;
            }
        } else {
            System.out.println("Gagal Melakukan Login...");
        }

    }
    }