import java.util.Scanner;

/**
 *  Main
 *  Deskripsi:
 *  Sesuai dengan namanya, Main.java dibuat sebagai PROGRAM UTAMA dari beberapa file.
 *  Program ini digunakan untuk memanggil Class-class lain yang berada di luar Class Main ini.
 *  Sehingga program bisa dikumpulkan menjadi satu di Class Main ini.
 */
public class Main {
    
    /*
        Deklarasi variabel yang menentukan apakah dia boleh login atau tidak, 
        deklarasi reusable variable, dan
        deklarasi data username dan password
    */ 
    public static boolean canLogin = false;
    public static String separator = "\n\n-------------------------------------------------------";
    public static String storedUsername = "Admin";
    public static String storedPassword = "admin";

    public static void main(String[] args) {
        // Deklarasi Scanner untuk input
        Scanner input = new Scanner(System.in);

        // Deklarasi Variabel
        int pilihanInput;

        // WAJIB Login sebelum masuk
        loginRegister();
        
        
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
            switch(pilihanInput){
                case 1:
                    meminjamBuku();         
                    break;
                case 2:
                    pengembalianBuku();     
                    break;
                case 3:
                    manajemenBuku();        
                    break;
                case 4:
                    pencarianBuku();        
                    break;
                case 5:
                    meminjamBukuDigital();  
                    break;
                case 6:
                    mengelolaStokBuku();        
                    break;
                default:        // Kondisi jika inputan TIDAK SESUAI dengan menu apapun
                    System.out.println("Maaf Input anda tidak sesuai, program keluar");
                    break;
            }
        } else {
            System.out.println("\nMaaf, tidak ada Username dengan password tersebut");
        }

    }

    
    //// METHOD AREA ////

    public static void loginRegister() {
        // Deklarasi Scanner dan variabel username
        Scanner input = new Scanner(System.in);
        String username, password;
        
        // Input Program
        System.out.println("Silahkan verifikasi diri anda terlebih dahulu\n");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        
        // Jika benar
        if ((username.equals(storedUsername)) && (password.equals(storedPassword))) {
            canLogin = true;
            System.out.println("\nBerhasil login!");
            System.out.println(separator);
        }
    }

    public static void meminjamBuku() {

        // Deklarasi Scanner untuk input 
        Scanner input = new Scanner(System.in);

        // Deklarasi stok buku akademik
        int stokBukuNonAkademik = 10;

        // Sambutan
        System.out.println(separator);
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
    public static void pengembalianBuku() {
        // Isi dari method
    }
    public static void manajemenBuku() {
        // Isi dari method
    }
    public static void pencarianBuku() {
        // Isi dari method
    }
    public static void meminjamBukuDigital() {
        // Isi dari method
    }
    public static void mengelolaStokBuku() {
        // Isi dari method
    }

}