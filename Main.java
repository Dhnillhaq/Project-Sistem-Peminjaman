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
        // Deklarasi Scanner untuk input //
        Scanner input = new Scanner(System.in);
        boolean toLogin = false;

        ////// Deklarasi Variabel //////

        //// Variabel Login dan Register
        int menuLogin;
        boolean onMenuLogin = true;
        String[][] userAccount = new String[10][2];
        // Akun default yang sudah terdaftar
        userAccount[0][0] = "Admin";
        userAccount[0][1] = "admin";

        userAccount[1][0] = "Aakhif";
        userAccount[1][1] = "password123";
        
        userAccount[2][0] = "Danendra";
        userAccount[2][1] = "danendrapassadhi";
        
        userAccount[3][0] = "Dhanil";
        userAccount[3][1] = "yakul123";

        // Variabel Login
        String usernameInput, passInput;
        boolean isAllowed = false, stillLogin = true;
        // Variabel Register
        String passConfirmation, regUsername = "", regPassword;
        boolean doRegister = true, doConfirm = true;

        
        // Variabel Pilih Menu dan Stok Buku (Case 1 & Case 2)
        String temaBuku1 = "Buku Akademik";
        String temaBuku2 = "Buku Non-Akademik";
        int pilihanInput, pilihBuku;
        int stokBukuAkademik = 10;
        int stokBukuNonAkademik = 20;

        // Variabel Nama, Jumlah Halaman dan Pengarang (Case 3)
        String namaBuku1 = "Malin Kundang";
        int jumlahHalBuku1 = 21;
        String pengarangBuku1 = "Dede Firmansyah";
        String namaBuku2, pengarangBuku2;

        int jumlahHalBuku2, validate;
        boolean isLoop = true;

        // Variabel Cari Buku (Case 4)
        String cariBuku, result = "";
        String[] arrayListBuku = {"Malin Kundang", "Negeri 5 Menara", "Perahu Kertas"};

        // Variabel Meminjam buku digital (Case 5)
        String buku, tipe;
        byte kodeBuku;

        // Variabel UI
        String separator = "------------------------------------------------------------------------";
        String esc = "\033[H\033[2J";

        // Variabel Masuk ke program utama
        boolean canLogin = false;

        // Variabel Validasi Menu 
        boolean exit = false;
        // Variabel kembali ke menu
        int menu;

        // WAJIB Login sebelum masuk
        // do {
        //     System.out.println("\nSilahkan verifikasi diri anda terlebih dahulu\n");
        //     System.out.print("Username: ");
        //     username = input.nextLine();
        //     System.out.print("Password: ");
        //     password = input.nextLine();

        //     // Jika benar
        //     if (username.equals(storedUsername)) {
        //         if (password.equals(storedPassword))
        //             canLogin = true;
        //         isLogin = true;

        //     }
        //     // Jika salah
        //     else {
        //         System.out.println("\nMaaf, tidak ada Username dengan password tersebut.");
        //         System.out.println("Coba lagi,");
        //         isLogin = false;
        //     }
        // } while (!isLogin);

        do {
            toLogin = false;
            // LOGIN || REGISTER
            do {
                System.out.println("\nSilahkan verifikasi diri anda terlebih dahulu\n");
                System.out.println("1] Login");
                System.out.println("2] Register");
                System.out.println("\n0] Exit Program");
                System.out.print("\n$> ");
                menuLogin = input.nextInt();

                switch (menuLogin) {
                    case 1:
                        input.nextLine();
                        System.out.println(esc);
                        System.out.println(separator);
                        
                        System.out.println("Silahkan LOGIN!\n");
                        do {
                            System.out.print("Username: ");
                            usernameInput = input.nextLine();
                            System.out.print("Password: ");
                            passInput = input.nextLine();

                            // Mengecek apakah username terdapat pada array
                            for (int i = 0; i < userAccount.length; i++) {
                            if (usernameInput.equals(userAccount[i][0]) && passInput.equals(userAccount[i][1])) {
                                    isAllowed = true;
                            } 
                            }

                            // Jika dia benar maka bisa login, begitu pula sebaliknya
                            if (isAllowed) {
                                System.out.println("\nBerhasil login!");
                                System.out.println("Selamat datang "+usernameInput);
                                isAllowed = false; // Reset Allowed login to false
                                stillLogin = false; // Keluar dari loop validasi login
                                onMenuLogin = false; // Keluar dari loop Menu Login
                                canLogin = true; // Diperbolehkan Login ke program utama
                            } else {
                                System.out.println("\nMaaf tidak ditemukan username dengan password tersebut\nSilahkan coba lagi!");
                                stillLogin = true;
                            }
                        } while (stillLogin);
        
                        onMenuLogin = false;
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println(esc);
                        System.out.println(separator);

                        System.out.println("Silahkan REGISTER Akun baru!\n");
                        do {
                            System.out.print("Masukkan username baru: ");
                            regUsername = input.nextLine();

                            // Proses
                            for (int i = 0; i < userAccount.length; i++) {
                                if (regUsername.equals(userAccount[i][0])) {
                                    System.out.println("Maaf username sudah pernah digunakan\n");
                                    break;
                                }
                                if (i == userAccount.length - 1) {
                                    doRegister = false;
                                    break;
                                }
                            }
                        } while (doRegister);
                        doRegister = true; // Reset doRegister
                        
                        System.out.print("Masukkan password baru: ");
                        regPassword = input.nextLine();

                        do {
                            System.out.print("\nKonfirmasi password: ");
                            passConfirmation = input.nextLine();

                            if (passConfirmation.equals(regPassword)) {
                                doConfirm = false;
                            } else {
                                System.out.println("Password tidak cocok! Coba lagi.");
                            }
                        } while (doConfirm);
                        doConfirm = true; // Reset doConfirm

                        // Proses menyimpan username dan password baru ke array 
                        System.out.println("Jumalh elemen = "+userAccount.length);
                        for (int i = 0; i < userAccount.length; i++) {
                            if (userAccount[i][0] == null) {
                                userAccount[i][0] = regUsername;
                                userAccount[i][1] = regPassword;
                                break;
                            }
                        }
                        System.out.println(esc);
                        System.out.println(separator);
                        System.out.println("Berhasil menambahkan user baru!");
                        
                        onMenuLogin = true;
                        break;
                    case 0:
                        System.out.println("\nProgram keluar...\n");
                        return;
                    default:
                        System.out.println(esc);
                        System.out.println(separator);
                        System.out.println("\nPilih sesuai menu!");
                        onMenuLogin = true;
                }
            } while (onMenuLogin);
            

            // Masuk ke program utama
            if (canLogin) {
                // Tampilan Menu
                do {
                    // Deklarasi default agar looping menu tetap berjalan
                    exit = true;

                    isLoop = true;
                    System.out.println(esc);
                    System.out.println(separator);
                    System.out.println("Selamat Datang di Perpustakaan! (Under Development)\n");

                    System.out.println("1] Peminjaman Buku");
                    System.out.println("2] Pengembalian Buku");
                    System.out.println("3] Manajemen Buku");
                    System.out.println("4] Pencarian Buku");
                    System.out.println("5] Buku Digital");
                    System.out.println("6] Pengelolaan Stok Buku");
                    System.out.println("\n0] Logout");

                    // Meminta input dari user
                    System.out.println("\nSilahkan pilih salah satu dari menu diatas");
                    System.out.print("$> ");
                    pilihanInput = input.nextInt();

                    // Memilih sesuai dengan input user
                    switch (pilihanInput) {
                        case 1:
                            // -Peminjaman Buku
                            // Sambutan
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI PEMINJAMAN BUKU\n");

                            // User menentukan jumlah peminjaman buku
                            System.out.println("[stok " + stokBukuAkademik + "]");
                            System.out.println(temaBuku1);
                            System.out.print("\nJumlah buku yang ingin dipinjam?\n$> ");
                            pilihBuku = input.nextInt();


                            // Melakukan pengurangan
                            stokBukuAkademik -= pilihBuku;

                            // Menampilkan hasil dari peminjaman
                            System.out.println("\n[stok " + stokBukuAkademik + "]");
                            System.out.println(temaBuku1);
                            break;
                        case 2:
                            // -Pengembalian Buku
                            // Sambutan
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI PENGEMBALIAN BUKU\n");

                            // User menentukan jumlah pengembalian buku
                            System.out.println("[stok " + stokBukuAkademik + "]");
                            System.out.println(temaBuku1);
                            System.out.println("\nJumlah buku yang ingin dikembalikan?");
                            System.out.print("$> ");
                            pilihBuku = input.nextInt();

                            // Melakukan Pengembalian Stok Sedia
                            stokBukuAkademik += pilihBuku;

                            // Menampilkan hasil dari pengembalian
                            System.out.printf("\n[stok %d]\n", stokBukuAkademik);
                            System.out.println(temaBuku1);

                            break;
                        case 3:
                            // -Manajemen Buku
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI MANAJEMEN BUKU\n");

                            // Menampilkan list buku
                            System.out.println("#List Buku");
                            System.out.println("Nama Buku: " + namaBuku1);
                            System.out.println("Pengarang: " + pengarangBuku1);
                            System.out.println("Jumlah Halaman: " + jumlahHalBuku1);

                            // Menanyakan apakah ingin mengubah/menambahkan/menghapus buku?
                            System.out.println(
                                    "\n1] Menambahkan Buku Baru\n2] Mengubah Buku\n3] Menghapus Buku\n0] Batalkan ");
                            System.out.print("\nApakah anda ingin melakukan sesuatu dengan data buku tersebut?\n$> ");
                            pilihanInput = input.nextInt();

                            // Switch Case jika memilih
                            switch (pilihanInput) {
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
                                    System.out.println("Nama Buku       : " + namaBuku1);
                                    System.out.println("Pengarang       : " + pengarangBuku1);
                                    System.out.println("Jumlah Halaman  : " + jumlahHalBuku1);
                                    System.out.println();
                                    System.out.println("Nama Buku       : " + namaBuku2 + " (New Added)");
                                    System.out.println("Pengarang       : " + pengarangBuku2);
                                    System.out.println("Jumlah Halaman  : " + jumlahHalBuku2);
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
                                    System.out.println("Nama Buku       : " + namaBuku1);
                                    System.out.println("Pengarang       : " + pengarangBuku1);
                                    System.out.println("Jumlah Halaman  : " + jumlahHalBuku1);
                                    System.out.println();
                                    break;
                                case 3:
                                    while (isLoop) {
                                        input.nextLine();
                                        System.out.print(
                                                "\nApakah anda yakin untuk menghapus data diatas?\n1]Ya.\n2]Tidak\n$> ");
                                        validate = input.nextInt();
                                        switch (validate) {
                                            case 1:
                                                namaBuku1 = "";
                                                pengarangBuku1 = "";
                                                jumlahHalBuku1 = 0;

                                                // Menampilkan list buku
                                                System.out.println("\n#List Buku (Tidak tersedia)");
                                                System.out.println("Nama Buku       : (kosong)");
                                                System.out.println("Pengarang       : (kosong)");
                                                System.out.println("Jumlah Halaman  : (kosong)");
                                                System.out.println();

                                                isLoop = false;
                                                break;
                                            case 2:
                                                System.out.println("Penghapusan data dibatalkan!\n");
                                                isLoop = false;
                                                break;
                                            default:
                                                System.out.println("Input salah");
                                                isLoop = true;
                                        }
                                    }
                                    break;
                                case 0:
                                    System.out.println("\nAnda membatalkan pemilihan...");
                                    break;
                                default:
                                    System.out.println("Input anda salah...\n");
                                    break;
                            }
                            break;
                        case 4:
                            // input.nextLine();
                            // // -Pencarian Buku
                            // // *Sambutan
                            // System.out.println(separator);
                            // System.out.println("SELAMAT DATANG DI PENCARIAN BUKU");

                            // // User menentukan buku yang dicari
                            // System.out.println("\nMasukkan buku yang ingin anda cari: ");
                            // System.out.print("$> ");
                            // cariBuku = input.nextLine();

                            // // Menampilkan buku sesuai inputan user
                            // if (cariBuku.equalsIgnoreCase(namaBuku1)) {
                            //     System.out.println("");
                            //     System.out.println("Hasil Penelusuran Kami: \n");
                            //     System.out.println(namaBuku1);
                            //     System.out.println(pengarangBuku1);
                            //     System.out.println(jumlahHalBuku1);
                            // } else if (cariBuku.equalsIgnoreCase("Buku Akademik")
                            //         || cariBuku.equalsIgnoreCase("akademik")) {
                            //     System.out.println("");
                            //     System.out.println("Hasil Penulusaran Kami: \n");
                            //     System.out.println("[stok " + stokBukuAkademik + "]");
                            //     System.out.println(temaBuku1);
                            // } else if (cariBuku.equalsIgnoreCase("Buku Non-Akademik")
                            //         || (cariBuku.equalsIgnoreCase("Non-Akademik"))) {
                            //     System.out.println("");
                            //     System.out.println("Hasil Penulusan Kami: \n");
                            //     System.out.println("[stok " + stokBukuNonAkademik + "]");
                            //     System.out.println(temaBuku2);
                            // } else {
                            //     System.out.println("\nMaaf,Buku tidak tersedia");

                            // }


                            // Ver 2 using Array 1 Dimension
                            input.nextLine();
                            // -Pencarian Buku
                            // *Sambutan
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI PENCARIAN BUKU");

                            // User menentukan buku yang dicari
                            System.out.println("\nMasukkan buku yang ingin anda cari: ");
                            System.out.print("$> ");
                            cariBuku = input.nextLine();

                            // Proses pencarian
                            for (int i = 0; i < arrayListBuku.length; i++) {
                                if (cariBuku.equalsIgnoreCase(arrayListBuku[i])) {
                                    result = "\nJudul buku ditemukan!\n---------------\n"+arrayListBuku[i];
                                    break;
                                } else {
                                    result = "\nMaaf,Buku tidak tersedia\n---------------\n*kosong";
                                }
                            }
                            System.out.println(result);

                            break;
                        case 5:

                            // - Buku Digital
                            input.nextLine();

                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI FITUR BUKU DIGITAL");
                            System.out
                                    .println("Kami disini menyediakan beberapa buku yang dapat diakses melalui digital\n");

                            // Memasukkan inputan tipe buku
                            System.out.print("Masukkan tipe buku fiksi/nonfiksi : ");
                            buku = input.nextLine();

                            // Menampilkan daftar buku fiksi
                            if (buku.equalsIgnoreCase("fiksi")) {
                                System.out.println("DAFTAR BUKU FIKSI\n - Novel\n - Komik\n - Cerpen ");
                                System.out.print("Masukkan tipe buku : "); // Melakukan inputan tipe buku fiksi
                                tipe = input.nextLine();
                                // Menampilkan daftar buku novel pada sistem
                                if (tipe.equalsIgnoreCase("novel")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku novel,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Negeri 5 Menara");
                                    System.out.println("2. Perahu Kertas");
                                    System.out.println("3. Bintang - Tere Liye");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku novel
                                    kodeBuku = input.nextByte();
                                    if (kodeBuku == 1) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1f1JkVi5-IZt3jODtT50r9JnVy5WszdQv/view?usp=drive_link");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 2) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1l7bQHLd5RZ3tmiw596aiL6oKs6tNYiqE/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 3) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1LIIWXtZU99DLZYOeVSw7ZQvINnas_NLZ/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else {
                                        System.out.println("Maaf inputan yang dimasukkan salah");
                                    }
                                    // Menampilkan daftar buku komik pada sistem
                                } else if (tipe.equalsIgnoreCase("komik")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku komik,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Naruto buku angin");
                                    System.out.println("2. Naruto Chapter 698");
                                    System.out.println("3. Si Juki Komik Strip");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku komik
                                    kodeBuku = input.nextByte();
                                    if (kodeBuku == 1) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/15Dh6bsELgTN6iBo4cNRPZMcctJdN-il8/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 2) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1bO7O1bcFKKkEghoF_cpe5_s5npzS1OrN/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 3) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1dTgqJUr6mKBMP5PkAbTeQhxiMjz6mJzu/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else {
                                        System.out.println("Maaf inputan yang dimasukkan salah");
                                    }
                                    // Menampilkan daftar buku cerpen pada sistem
                                } else if (tipe.equalsIgnoreCase("cerpen")) {
                                    System.out.println("Kumupulan Cerpen-Cerpen");
                                    System.out.println(
                                            "https://drive.google.com/file/d/1XOYJ_OgLgswpDtxy8Si1GRmrfxTaIc1g/view?usp=sharing");
                                    System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                } else {
                                    System.out.println("Maaf inputan yang dimasukkan salah");
                                }

                                // Menampilkan daftar buku nonfiksi
                            } else if (buku.equalsIgnoreCase("nonfiksi")) {
                                System.out.println("DAFTAR BUKU NONFIKSI\n - Majalah\n - Jurnal\n - Pendidikan\n");
                                System.out.print("Masukkan tipe buku : "); // Melakukan inputan tipe buku nonfiksi
                                tipe = input.nextLine();

                                // Menampilkan daftar buku majalah pada sistem
                                if (tipe.equalsIgnoreCase("majalah")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku majalah,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Majalah Bobo 25 Maret 2021");
                                    System.out.println("2. Majalah Pendis - Skema Pendanaan Pendidikan Islam");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku
                                                                                    // majalah
                                    kodeBuku = input.nextByte();
                                    if (kodeBuku == 1) {
                                        System.out.println(
                                                "https://library.trunojoyo.ac.id/files/epaper/Bobo/majalah%20BOBO%2020210325.pdf");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 2) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1bO7O1bcFKKkEghoF_cpe5_s5npzS1OrN/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else {
                                        System.out.println("Maaf inputan yang dimasukkan salah");
                                    }

                                    // Menampilkan daftar buku jurnal pada sistem
                                } else if (tipe.equalsIgnoreCase("Jurnal")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku jurnal,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Jurnal Teknik Informatika");
                                    System.out.println("2. Jurnal Ekonomi");
                                    System.out.println("3. Jurnal Teknik Sipil");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku jurnal
                                    kodeBuku = input.nextByte();
                                    if (kodeBuku == 1) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/11t6kE0qD6H3S144Drz6rifm6UBymz9lb/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 2) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/15mafg3JdQHoADMpu5HQh7wBRZg6mE_oe/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 3) {
                                        System.out.println(
                                                "https://drive.google.com/file/d/1wr4eXFWupiQruXJRY0Vp8W0Y9pBK9zLQ/view?usp=sharing");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else
                                        System.out.println("Maaf inputan yang dimasukkan salah");

                                    // Menampilkan daftar buku pendidikan pada sistem
                                } else if (tipe.equalsIgnoreCase("pendidikan")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku jurnal,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Buku Informatika Kelas XI");
                                    System.out.println("2. Buku Informatika Kelas X");
                                    System.out.println("3. Buku Teknik Sipil UI");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku
                                                                                    // pendidikan
                                    kodeBuku = input.nextByte();
                                    if (kodeBuku == 1) {
                                        System.out.println(
                                                "https://static.buku.kemdikbud.go.id/content/pdf/bukuteks/kurikulum21/Informatika-BS-KLS-XI.pdf");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 2) {
                                        System.out.println(
                                                "http://118.98.166.64/bukuteks/assets/uploads/pdf/INFORMATIKA-BS-KLS_X_Rev.pdf");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else if (kodeBuku == 3) {
                                        System.out.println(
                                                "https://eng.ui.ac.id/wp-content/uploads/BUKU-SIPIL-INDONESIA.pdf");
                                        System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                    } else
                                        System.out.println("Maaf inputan yang dimasukkan salah");
                                } else {
                                    System.out.println("Maaf inputan");
                                }
                            } else {
                                System.out.println("Maaf pilihan tidak tersedia");
                            }
                            break;
                        case 6:
                            // -Mengelola Stok Buku
                            // *Isi dari case

                            break;
                        case 0:
                            
                            // Logout User (User meminta untuk logout)
                            toLogin = true; // Akan menuju ke halaman login
                            exit = false; // Akan keluar dari loop menu
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("Berhasil Logout!");
                            break;
                        default: // Kondisi jika inputan TIDAK SESUAI dengan menu apapun
                            System.out.println("Maaf Input anda tidak sesuai...\n");
                            break;

                    }

                    if (!toLogin) { // Kondisi akan dijalankan jika user tidak meminta logout
                        System.out.println("\nApakah anda ingin kembali ke menu?\n1] Ya.\n2] Tidak(Logout)");
                        System.out.print("$> ");
    
                        menu = input.nextInt();
    
                        switch (menu) {
                            case 1:
                                exit = true;
                                break;
                            case 2:
                                exit = false;
                                toLogin = true; // Kembali ke halaman Login
                                System.out.println(esc);
                                System.out.print(separator);
                                System.out.println("\nTerima kasih telah datang, berhasil logout..");
                                break;
                            default:
                                System.out.println(esc);
                                System.out.print(separator);
                                System.out.println("Input yang anda masukkan salah");
                                break;
                        }
                    }

                } while (exit);
            } else {
                System.out.println("Gagal Melakukan Login...");
            }
        } while (toLogin);

        
    }

}

