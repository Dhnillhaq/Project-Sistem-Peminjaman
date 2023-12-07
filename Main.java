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
    static Scanner input = new Scanner(System.in);
    static String[][] listBuku = new String[15][6];

    // Fungsi saranJudul jika input tidak sesuai dengan judul dalam listBuku
    static void saranJudul(String cariBuku, String[][] arrayData) {
        String saranIndex[] = new String[15];
        // Loop untuk mengecek per judul dalam listBuku
        for (int i = 0; i < arrayData.length; i++) {
            if (arrayData[i][0] != null) {
                String[] tempSplitData = arrayData[i][0].split("[- ]+"); // Pemisahan perkata Judul dalam listBuku
                String[] tempSplitInput = cariBuku.split("[-., ]+"); // Pemisahan perkata input user

                //Loop yang akan mengecek input dari user apakah terdiri dari kata pada judul listBuku
                Outerloop:for (int j = 0; j < tempSplitInput.length; j++) {
                    for (int j2 = 0; j2 < tempSplitData.length; j2++) {
                        if (tempSplitInput[j].equalsIgnoreCase(tempSplitData[j2])) {
                            for (int k = 0; k < tempSplitInput.length; k++) {
                                if (saranIndex[k] == null) { 
                                    saranIndex[k] = i + ""; // Menyimpan index judul pada nilai null.
                                    break Outerloop;
                                }
                            }
                        }
                    }
                }
            }
        }
        // Menampilkan hasil pengecekan apakah ada saran
        if (saranIndex[0] != null) {
            System.out.println("Mungkin maksud anda adalah,\n");
        } else {
            System.out.println("\nMaaf, Kami tidak memiliki judul buku yang anda cari.\nCoba lagi dengan memperbaiki input anda.");
            return;
        }
        for (int i = 0; i < saranIndex.length; i++) {
            if (saranIndex[i] == null) {
                return;
            } else {
                int indexKe = Integer.parseInt(saranIndex[i]);
                System.out.println(" - " + arrayData[indexKe][0]);
            }
        }
    }

    // Fungsi Pencarian Buku
    static boolean cariBuku(String cariBuku, int i) {
        if (i >= 0 && i < listBuku.length) {
            if (cariBuku.equalsIgnoreCase(listBuku[i][0])) {
                System.out.println("\n---------------------------------\nHasil Pencarian kami:\n\nNomor Buku     : "
                        + listBuku[i][4] + "\nJudul buku     : " + listBuku[i][0] + "\nNama Pengarang : "
                        + listBuku[i][2]
                        + "\nJumlah Halaman : " + listBuku[i][1] + "\nStok Tersedia  : " + listBuku[i][5]);
                        return false;
            } else {
                return cariBuku(cariBuku, i + 1);
            }
        } else {
            saranJudul(cariBuku, listBuku);
            return true;
        }
    }

    // Fungsi untuk menampilkan list buku
    static void TampilBuku() {
        for (int i = 0; i < listBuku.length; i++) {
            if (listBuku[i][0] != null) {
                System.out.println("no." + listBuku[i][4]);
                System.out.println("Judul buku   : " + listBuku[i][0]);
                System.out.println("Jumlah stock : " + listBuku[i][5] + "\n");
            }
        }
    }

    // Fungsi untuk menginput nomor buku
    static int inputNoBuku() {
        int noBuku;
        do {
            System.out.print("Masukkan NOMOR BUKU yang akan diubah: ");
            noBuku = input.nextInt();
            if (noBuku > 0 && noBuku <= listBuku.length) {
                if (listBuku[noBuku - 1][0] != null) {
                    break;
                }
            }
            System.out.println("Nomor buku tidak ditemukan!");
        } while (true);
        return noBuku;
    }

    // Fungsi untuk menambahkan stok buku
    static void tambahBuku(int pilihan) {
        System.out.print("Tambah stock buku : ");
        int tambah = input.nextInt();
        int hasil = Integer.parseInt(listBuku[pilihan][5]) + tambah;
        listBuku[pilihan][5] = hasil + "";
        System.out.println("buku berhasil ditambahkan");
    }

    // Fungsi untuk mengurangi stok buku
    static void kurangiBuku(int pilihan) {
        System.out.print("Kurangi stock buku : ");
        int kurangi = input.nextInt();
        int hasil = Integer.parseInt(listBuku[pilihan][5]) - kurangi;
        listBuku[pilihan][5] = hasil + "";
        System.out.println("buku berhasil dikurangi");
    }

    public static void main(String[] args) {
        // Deklarasi Scanner untuk input //
        boolean toLogin = false;

        ////// Deklarasi Variabel //////

        ///// Variabel Umum /////
        // Using array 2 dimensi
        // Index 0 = Nama Buku
        // Index 1 = Halaman
        // Index 2 = Pengarang
        // Index 3 = Tema Buku
        // Index 4 = Nomor Buku (Primary Key/Kunci)

        // 3 Buku Non Akademik dan 3 Buku Akademik Awal
        listBuku[0][0] = "Metode Penelitian Kualitatif";
        listBuku[0][1] = "312";
        listBuku[0][2] = "M. Nazir";
        listBuku[0][3] = "Akademik";
        listBuku[0][4] = "1";
        listBuku[0][5] = "5";

        listBuku[1][0] = "Ayat-Ayat Cinta";
        listBuku[1][1] = "368";
        listBuku[1][2] = "Habiburrahman El Shirazy";
        listBuku[1][3] = "Non Akademik";
        listBuku[1][4] = "2";
        listBuku[1][5] = "5";

        listBuku[2][0] = "Pengantar Sosiologi";
        listBuku[2][1] = "250";
        listBuku[2][2] = "Soerjono Soekanto";
        listBuku[2][3] = "Akademik";
        listBuku[2][4] = "3";
        listBuku[2][5] = "5";

        listBuku[3][0] = "Sebuah Pengantar";
        listBuku[3][1] = "340";
        listBuku[3][2] = "Achmad Charris Zubair";
        listBuku[3][3] = "Akademik";
        listBuku[3][4] = "4";
        listBuku[3][5] = "5";

        listBuku[4][0] = "Laskar Pelangi";
        listBuku[4][1] = "529";
        listBuku[4][2] = "Andrea Hirata";
        listBuku[4][3] = "Non Akademik";
        listBuku[4][4] = "5";
        listBuku[4][5] = "5";

        listBuku[5][0] = "Perahu Kertas";
        listBuku[5][1] = "368";
        listBuku[5][2] = "Dee Lestari";
        listBuku[5][3] = "Non Akademik";
        listBuku[5][4] = "6";
        listBuku[5][5] = "5";

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
        int pilihanInput, pilihBuku, pinjamBuku, selectedStockBuku;
        boolean isMinjam = true;

        // Variabel Nama, Jumlah Halaman dan Pengarang (Case 3)
        int availableSlot = 0, noBuku;
        String sortir = "Semua", jenisBuku;
        boolean isMistake = true;
        int validate;
        boolean isLoop = true;
        String namaBukuTemp, jumHalTemp, pengarangTemp, jumStockBukuTemp;

        // Variabel Cari Buku (Case 4)
        String cariBuku;
        boolean iyakah;

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
                                System.out.println("Selamat datang " + usernameInput);
                                isAllowed = false; // Reset Allowed login to false
                                stillLogin = false; // Keluar dari loop validasi login
                                onMenuLogin = false; // Keluar dari loop Menu Login
                                canLogin = true; // Diperbolehkan Login ke program utama
                            } else {
                                System.out.println(
                                        "\nMaaf tidak ditemukan username dengan password tersebut\nSilahkan coba lagi!");
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
                        System.out.println("Jumlah elemen = " + userAccount.length);
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

                            // User menentukan tema buku
                            System.out.println(
                                    "Pilih nomor buku yang ingin anda pinjam:\n");
                            for (int i = 0; i < listBuku.length; i++) {
                                if (listBuku[i][0] != null) {
                                    System.out.println("Buku " + (i + 1) + " :" + listBuku[i][0]);
                                }
                            }
                            System.out.println("\n0] Batalkan\n");

                            System.out.print("$> ");
                            pilihBuku = input.nextInt();

                            do {
                                if (pilihBuku == 0) {
                                    System.out.println("\nPeminjaman dibatalkan...");
                                    break;
                                }
                                if (pilihBuku > 0 && pilihBuku <= listBuku.length) {
                                    if (listBuku[pilihBuku - 1][0] != null) {
                                        break; // Keluar dari loop validasi
                                    }
                                }
                                System.out.println("Pilihan Buku tidak tersedia!\n");
                                System.out.print("$> ");
                                pilihBuku = input.nextInt();
                            } while (true);

                            if (pilihBuku == 0)
                                break;

                            // Sambutan
                            System.out.println(esc);
                            System.out.println("Buku : " + listBuku[pilihBuku - 1][0]);
                            System.out.println("[Stok tersedia = " + listBuku[pilihBuku - 1][5] + " ]");

                            // Menyimpan jumlah stock buku ke variabel
                            selectedStockBuku = Integer.parseInt(listBuku[pilihBuku - 1][5]);

                            // User menentukan jumlah peminjaman buku
                            do {
                                System.out.print("\nJumlah buku yang ingin dipinjam?\n$> ");
                                pinjamBuku = input.nextInt();

                                if (pinjamBuku <= selectedStockBuku) {
                                    // Melakukan pengurangan
                                    selectedStockBuku -= pinjamBuku;

                                    // Menyimpan jumlah stock buku akhir ke array listBuku semula
                                    listBuku[pilihBuku - 1][5] = String.valueOf(selectedStockBuku);
                                    selectedStockBuku = 0; // Reset selected Stock buku ke 0

                                    isMinjam = false;
                                } else {
                                    System.out.println("Input anda lebih besar dari stock yang kita punya!\n");
                                    isMinjam = true;
                                }

                                // Menampilkan hasil dari peminjaman
                                System.out.println("Buku : " + listBuku[pilihBuku - 1][0]);
                                System.out.println("[Stok Buku = " + listBuku[pilihBuku - 1][5] + "]");
                            } while (isMinjam);

                            break;
                        case 2:
                            // -Pengembalian Buku
                            // // Sambutan
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI PENGEMBALIAN BUKU\n");

                            System.out.println(
                                    "Pilih nomor buku yang ingin anda kembalikan:\n");
                            for (int i = 0; i < listBuku.length; i++) {
                                if (listBuku[i][0] != null) {
                                    System.out.println("Buku " + (i + 1) + " :" + listBuku[i][0]);
                                }
                            }
                            System.out.println("\n0] Batalkan\n");

                            System.out.print("$> ");
                            pilihBuku = input.nextInt();

                            do {
                                if (pilihBuku == 0) {
                                    System.out.println("\nPengembalian buku dibatalkan...");
                                    break;
                                }
                                if (pilihBuku > 0 && pilihBuku <= listBuku.length) {
                                    if (listBuku[pilihBuku - 1][0] != null) {
                                        break; // Keluar dari loop validasi
                                    }
                                }
                                System.out.println("Pilihan Buku tidak tersedia!\n");
                                System.out.print("$> ");
                                pilihBuku = input.nextInt();
                            } while (true);

                            if (pilihBuku == 0)
                                break;

                            System.out.println(esc);
                            System.out.println("Buku : " + listBuku[pilihBuku - 1][0]);
                            System.out.println("[Stok tersedia = " + listBuku[pilihBuku - 1][5] + "]");

                            // User menentukan jumlah pengembalian buku
                            System.out.print("\nJumlah buku yang ingin dikembalikan?\n$> ");
                            pinjamBuku = input.nextInt();

                            // Menyimpan jumlah selected stock buku ke variabel
                            selectedStockBuku = Integer.parseInt(listBuku[pilihBuku - 1][5]);

                            // Melakukan penjumlahan
                            selectedStockBuku += pinjamBuku;

                            // Menyimpan selected stock buku ke array kembali
                            listBuku[pilihBuku - 1][5] = String.valueOf(selectedStockBuku);
                            selectedStockBuku = 0; // Reset selected stock buku ke 0

                            // Menampilkan hasil dari pengembalian
                            System.out.println("Buku : " + listBuku[pilihBuku - 1][0]);
                            System.out.println("[Stok Buku = " + listBuku[pilihBuku - 1][5] + "]");

                            break;
                        case 3:
                            // -Manajemen Buku
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI MANAJEMEN BUKU\n");

                            sortir = "Semua";
                            do {
                                if (sortir == "Semua") {
                                    // Menampilkan list buku
                                    System.out.println("# LIST BUKU #");
                                    System.out.println("--------------------------------------");
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] != null) {
                                            System.out.println("------------------");
                                            System.out.println("| NOMOR BUKU = " + listBuku[i][4] + " |");
                                            System.out.println("-------------------------------------");
                                            System.out.println("Nama Buku: " + listBuku[i][0]);
                                            System.out.println("Jumlah Halaman: " + listBuku[i][1]);
                                            System.out.println("Pengarang: " + listBuku[i][2]);
                                            System.out.println("Jenis Buku: " + listBuku[i][3]);
                                            System.out.println("Stock Buku: " + listBuku[i][5] + " buku tersedia");
                                            System.out.println("--------------------------------------\n");
                                        }
                                    }
                                } else if (sortir == "Akademik") {
                                    // Menampilkan list buku
                                    System.out.println("# LIST BUKU #");
                                    System.out.println("--------------------------------------");
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] != null && listBuku[i][3] == "Akademik") {
                                            System.out.println("------------------");
                                            System.out.println("| NOMOR BUKU = " + listBuku[i][4] + " |");
                                            System.out.println("-------------------------------------");
                                            System.out.println("Nama Buku: " + listBuku[i][0]);
                                            System.out.println("Jumlah Halaman: " + listBuku[i][1]);
                                            System.out.println("Pengarang: " + listBuku[i][2]);
                                            System.out.println("Jenis Buku: " + listBuku[i][3]);
                                            System.out.println("Stock Buku: " + listBuku[i][5] + " buku tersedia");
                                            System.out.println("--------------------------------------\n");
                                        }
                                    }
                                } else if (sortir == "Non Akademik") {
                                    // Menampilkan list buku
                                    System.out.println("# LIST BUKU #");
                                    System.out.println("--------------------------------------");
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] != null && listBuku[i][3] == "Non Akademik") {
                                            System.out.println("------------------");
                                            System.out.println("| NOMOR BUKU = " + listBuku[i][4] + " |");
                                            System.out.println("-------------------------------------");
                                            System.out.println("Nama Buku: " + listBuku[i][0]);
                                            System.out.println("Jumlah Halaman: " + listBuku[i][1]);
                                            System.out.println("Pengarang: " + listBuku[i][2]);
                                            System.out.println("Jenis Buku: " + listBuku[i][3]);
                                            System.out.println("Stock Buku: " + listBuku[i][5] + " buku tersedia");
                                            System.out.println("--------------------------------------\n");
                                        }
                                    }
                                }

                                // Menanyakan apakah ingin mengubah/menambahkan/menghapus buku?
                                if (sortir == "Semua") {
                                    System.out.println("\nSortir:\n11] Akademik\t22] Non Akademik\t<{99] Semua Buku}>");
                                } else if (sortir == "Non Akademik") {
                                    System.out.println("\nSortir:\n11] Akademik\t<{22] Non Akademik}>\t99] Semua Buku");
                                } else if (sortir == "Akademik") {
                                    System.out.println("\nSortir:\n<{11] Akademik}>\t22] Non Akademik\t99] Semua Buku");
                                }
                                System.out.println(
                                        "\n1] Menambahkan Buku Baru\n2] Mengubah Buku\n3] Menghapus Buku\n\n0] Batalkan ");
                                System.out
                                        .print("\nApakah anda ingin melakukan sesuatu dengan data buku tersebut?\n$> ");
                                pilihanInput = input.nextInt();

                                switch (pilihanInput) {
                                    case 11:
                                        sortir = "Akademik";
                                        System.out.println();
                                        break;
                                    case 22:
                                        sortir = "Non Akademik";
                                        System.out.println();
                                        break;
                                    case 99:
                                        sortir = "Semua";
                                        System.out.println();
                                        break;
                                }

                            } while (pilihanInput == 11 || pilihanInput == 22 || pilihanInput == 99);

                            // Switch Case jika memilih
                            switch (pilihanInput) {
                                case 1:
                                    // Cek index yang kosong
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] == null) {
                                            availableSlot = i;
                                            break;
                                        }
                                    }

                                    input.nextLine();
                                    System.out.println("\n---MENAMBAHKAN BUKU BARU---");
                                    System.out.print("Nama Buku         : ");
                                    listBuku[availableSlot][0] = input.nextLine();
                                    System.out.print("Jumlah Halaman    : ");
                                    listBuku[availableSlot][1] = input.nextLine();
                                    System.out.print("Pengarang         : ");
                                    listBuku[availableSlot][2] = input.nextLine();
                                    System.out.print("Jumlah Stock Buku (harus berupa angka) : ");
                                    listBuku[availableSlot][5] = String.valueOf(input.nextInt()); // Konversi input ke
                                                                                                  // string
                                    input.nextLine();
                                    do {
                                        System.out.println("\n1] Akademik\t2] Non Akademik");
                                        System.out.print("Pilih jenis buku (1/2): ");
                                        jenisBuku = input.nextLine();
                                        switch (jenisBuku) {
                                            case "1":
                                                listBuku[availableSlot][3] = "Akademik";
                                                isMistake = false;
                                                break;
                                            case "2":
                                                listBuku[availableSlot][3] = "Non Akademik";
                                                isMistake = false;
                                                break;
                                            default:
                                                System.out.println("\nPilihan anda salah, pilih angka 1/2!");
                                        }
                                    } while (isMistake);
                                    isMistake = true;
                                    listBuku[availableSlot][4] = "" + (availableSlot + 1) + "";

                                    System.out.println("\nDATA BERHASIL DITAMBAHKAN!\n");

                                    // Menampilkan list buku
                                    System.out.println("# LIST BUKU #");
                                    System.out.println("--------------------------------------");
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] != null) {
                                            System.out.println("No Buku         : " + listBuku[i][4]);
                                            System.out.println("Nama Buku       : " + listBuku[i][0]);
                                            System.out.println("Jumlah Halaman  : " + listBuku[i][1]);
                                            System.out.println("Pengarang       : " + listBuku[i][2]);
                                            System.out.println("Jenis Buku      : " + listBuku[i][3]);
                                            System.out
                                                    .println("Stock Buku      : " + listBuku[i][5] + " buku tersedia");
                                            System.out.println("--------------------------------------");
                                        }
                                    }

                                    break;
                                case 2:
                                    input.nextLine();
                                    System.out.println("\n---MENGUBAH BUKU---");
                                    do {
                                        System.out.print("Masukkan NOMOR BUKU yang akan diubah: ");
                                        noBuku = input.nextInt();
                                        if (noBuku > 0 && noBuku <= listBuku.length) {
                                            if (listBuku[noBuku - 1][0] != null) {
                                                break;
                                            }
                                        }
                                        System.out.println("Nomor buku tidak ditemukan!");
                                    } while (true);

                                    input.nextLine();
                                    System.out.println(
                                            "\nEdit data Buku... (Berikan input '-' jika tidak ingin merubah)");
                                    System.out.print("Nama Buku     : ");
                                    namaBukuTemp = input.nextLine();
                                    listBuku[noBuku - 1][0] = (namaBukuTemp.equals("-") || namaBukuTemp.equals(""))
                                            ? listBuku[noBuku - 1][0]
                                            : namaBukuTemp;
                                    System.out.print("Jumlah Halaman: ");
                                    jumHalTemp = input.nextLine();
                                    listBuku[noBuku - 1][1] = (jumHalTemp.equals("-") || jumHalTemp.equals(""))
                                            ? listBuku[noBuku - 1][1]
                                            : jumHalTemp;
                                    System.out.print("Pengarang     : ");
                                    pengarangTemp = input.nextLine();
                                    listBuku[noBuku - 1][2] = (pengarangTemp.equals("-") || pengarangTemp.equals(""))
                                            ? listBuku[noBuku - 1][2]
                                            : pengarangTemp;
                                    System.out.print("Jumlah Stock Buku (harus berupa angka) : ");
                                    jumStockBukuTemp = input.nextLine();
                                    listBuku[noBuku - 1][5] = (jumStockBukuTemp.equals("-")
                                            || jumStockBukuTemp.equals("")) ? listBuku[noBuku - 1][5]
                                                    : String.valueOf(Integer.parseInt(jumStockBukuTemp)); // Konversi
                                                                                                          // input ke
                                                                                                          // string
                                    // Reset Temp Var
                                    namaBukuTemp = "";
                                    jumHalTemp = "";
                                    pengarangTemp = "";
                                    jumStockBukuTemp = "";
                                    do {
                                        System.out.println(
                                                "\n1] Akademik\t2] Non Akademik\t\t0] Default (Tidak mengubah)");
                                        System.out.print("Pilih jenis buku (1/2): ");
                                        jenisBuku = input.nextLine();
                                        switch (jenisBuku) {
                                            case "1":
                                                listBuku[noBuku - 1][3] = "Akademik";
                                                isMistake = false;
                                                break;
                                            case "2":
                                                listBuku[noBuku - 1][3] = "Non Akademik";
                                                isMistake = false;
                                                break;
                                            case "0":
                                                isMistake = false;
                                                break;
                                            case "-":
                                                isMistake = false;
                                                break;
                                            default:
                                                System.out.println("\nPilihan anda salah, pilih angka 1/2!");
                                        }
                                    } while (isMistake);
                                    isMistake = true;

                                    System.out.println("\nDATA BERHASIL DIUBAH\n");

                                    // Menampilkan list buku
                                    System.out.println("# LIST BUKU #");
                                    System.out.println("--------------------------------------");
                                    for (int i = 0; i < listBuku.length; i++) {
                                        if (listBuku[i][0] != null) {
                                            System.out.println("No Buku         : " + listBuku[i][4]);
                                            System.out.println("Nama Buku       : " + listBuku[i][0]);
                                            System.out.println("Jumlah Halaman  : " + listBuku[i][1]);
                                            System.out.println("Pengarang       : " + listBuku[i][2]);
                                            System.out.println("Jenis Buku      : " + listBuku[i][3]);
                                            System.out
                                                    .println("Stock Buku      : " + listBuku[i][5] + " buku tersedia");
                                            System.out.println("--------------------------------------");
                                        }
                                    }
                                    break;
                                case 3:
                                    while (isLoop) {
                                        input.nextLine();
                                        System.out.println("\n---MENGHAPUS BUKU---");
                                        do {
                                            System.out.print("Masukkan NOMOR BUKU yang akan dihapus: ");
                                            noBuku = input.nextInt();
                                            if (noBuku > 0 && noBuku <= listBuku.length) {
                                                if (listBuku[noBuku - 1][0] != null) {
                                                    break;
                                                }
                                            }
                                            System.out.println("Nomor buku tidak ditemukan!");
                                        } while (true);

                                        System.out.print(
                                                "\nApakah anda yakin untuk menghapus data diatas?\n1]Ya.\n2]Tidak\n$> ");
                                        validate = input.nextInt();
                                        switch (validate) {
                                            case 1:
                                                // Menghapus buku
                                                listBuku[noBuku - 1][0] = null;
                                                listBuku[noBuku - 1][1] = null;
                                                listBuku[noBuku - 1][2] = null;

                                                // Menampilkan list buku
                                                System.out.println("# LIST BUKU #");
                                                System.out.println("--------------------------------------");
                                                for (int i = 0; i < listBuku.length; i++) {
                                                    if (listBuku[i][0] != null) {
                                                        System.out.println("No Buku         : " + listBuku[i][4]);
                                                        System.out.println("Nama Buku       : " + listBuku[i][0]);
                                                        System.out.println("Jumlah Halaman  : " + listBuku[i][1]);
                                                        System.out.println("Pengarang       : " + listBuku[i][2]);
                                                        System.out.println("Jenis Buku      : " + listBuku[i][3]);
                                                        System.out.println("Stock Buku      : " + listBuku[i][5]
                                                                + " buku tersedia");
                                                        System.out.println("--------------------------------------");
                                                    }
                                                }
                                                isLoop = false;
                                                break;
                                            case 2:
                                                System.out.println("\nPenghapusan data dibatalkan!\n");
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
                            input.nextLine();
                            // -Pencarian Buku
                            // *Sambutan
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI PENCARIAN BUKU");
                            do {
                                
                                // User menentukan buku yang dicari
                                System.out.println("\nMasukkan buku yang ingin anda cari: ");
                                System.out.print("$> ");
                                cariBuku = input.nextLine();
                                
                                // Proses pencarian
                                iyakah = cariBuku(cariBuku, 0);
                                } while (iyakah);
                            break;
                        case 5:

                            // - Buku Digital
                            input.nextLine();

                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI FITUR BUKU DIGITAL");
                            System.out.println(
                                    "Kami disini menyediakan beberapa buku yang dapat diakses melalui digital\n");

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
                                            "\nKami menyediakan beberapa buku novel,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Negeri 5 Menara");
                                    System.out.println("2. Perahu Kertas");
                                    System.out.println("3. Bintang - Tere Liye");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku
                                                                                      // novel
                                    kodeBuku = input.nextByte();
                                    System.out.println();
                                    switch (kodeBuku) {
                                        case 1:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1f1JkVi5-IZt3jODtT50r9JnVy5WszdQv/view?usp=drive_link");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 2:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1l7bQHLd5RZ3tmiw596aiL6oKs6tNYiqE/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 3:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1LIIWXtZU99DLZYOeVSw7ZQvINnas_NLZ/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        default:
                                            System.out.println("Maaf inputan yang dimasukkan salah");
                                            break;
                                    }
                                    // Menampilkan daftar buku komik pada sistem
                                } else if (tipe.equalsIgnoreCase("komik")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku komik,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Naruto buku angin");
                                    System.out.println("2. Naruto Chapter 698");
                                    System.out.println("3. Si Juki Komik Strip");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku
                                                                                      // komik
                                    kodeBuku = input.nextByte();
                                    System.out.println();
                                    switch (kodeBuku) {
                                        case 1:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/15Dh6bsELgTN6iBo4cNRPZMcctJdN-il8/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 2:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1bO7O1bcFKKkEghoF_cpe5_s5npzS1OrN/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 3:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1dTgqJUr6mKBMP5PkAbTeQhxiMjz6mJzu/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        default:
                                            System.out.println("Maaf inputan yang dimasukkan salah");
                                            break;
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
                                    System.out.println();
                                    switch (kodeBuku) {
                                        case 1:
                                            System.out.println(
                                                    "https://library.trunojoyo.ac.id/files/epaper/Bobo/majalah%20BOBO%2020210325.pdf");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 2:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1bO7O1bcFKKkEghoF_cpe5_s5npzS1OrN/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        default:
                                            System.out.println("Maaf inputan yang dimasukkan salah");
                                            break;
                                    }
                                    // Menampilkan daftar buku jurnal pada sistem
                                } else if (tipe.equalsIgnoreCase("Jurnal")) {
                                    System.out.println(
                                            "Kami menyediakan beberapa buku jurnal,dengan beberapa judul yang diantaranya : ");
                                    System.out.println("1. Jurnal Teknik Informatika");
                                    System.out.println("2. Jurnal Ekonomi");
                                    System.out.println("3. Jurnal Teknik Sipil");
                                    System.out.print("Masukkan nomor judul buku : "); // Melakukan inputan judul buku
                                                                                      // jurnal
                                    kodeBuku = input.nextByte();
                                    System.out.println();
                                    switch (kodeBuku) {
                                        case 1:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/11t6kE0qD6H3S144Drz6rifm6UBymz9lb/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 2:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/15mafg3JdQHoADMpu5HQh7wBRZg6mE_oe/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 3:
                                            System.out.println(
                                                    "https://drive.google.com/file/d/1wr4eXFWupiQruXJRY0Vp8W0Y9pBK9zLQ/view?usp=sharing");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        default:
                                            System.out.println("Maaf inputan yang dimasukkan salah");
                                            break;
                                    }
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
                                    System.out.println();
                                    switch (kodeBuku) {
                                        case 1:
                                            System.out.println(
                                                    "https://static.buku.kemdikbud.go.id/content/pdf/bukuteks/kurikulum21/Informatika-BS-KLS-XI.pdf");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 2:
                                            System.out.println(
                                                    "http://118.98.166.64/bukuteks/assets/uploads/pdf/INFORMATIKA-BS-KLS_X_Rev.pdf");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        case 3:
                                            System.out.println(
                                                    "https://eng.ui.ac.id/wp-content/uploads/BUKU-SIPIL-INDONESIA.pdf");
                                            System.out.println("Klik ctrl+klik/option+klik untuk mengakses buku");
                                            break;

                                        default:
                                            System.out.println("Maaf inputan yang dimasukkan salah");
                                            break;
                                    }
                                } else {
                                    System.out.println("Maaf inputan salah");
                                }
                            } else {
                                System.out.println("Maaf pilihan tidak tersedia");
                            }
                            break;
                        case 6:
                            // -Mengelola Stok Buku
                            System.out.println(esc);
                            System.out.println(separator);
                            System.out.println("SELAMAT DATANG DI FITUR BUKU DIGITAL\n");
                            System.out.println("1. Tampilkan buku tersedia\n2. Tambah buku\n3. Kurang buku");

                            System.out.print("Masukkan pilihan :");
                            int pilihan = input.nextInt();

                            switch (pilihan) {
                                case 1:
                                    TampilBuku();
                                    break;
                                case 2:
                                    TampilBuku();
                                    int pilih = inputNoBuku();
                                    tambahBuku(pilih - 1);
                                    TampilBuku();
                                    break;
                                case 3:
                                    TampilBuku();
                                    pilih = inputNoBuku();
                                    kurangiBuku(pilih - 1);
                                    TampilBuku();
                                    break;

                                default:
                                    System.out.println("Maaf inputan anda salah");
                                    break;
                            }

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
