<div id="top"></div>

# Flowchart - Sistem Peminjaman [Perpustakaan] 

![Flowchart](https://img.shields.io/badge/Flowchart-f83684?style=flat-square) ![Library](https://img.shields.io/badge/Library-blue?style=flat-square)

## Team:
- Akhmad Aakhif Athallah
- Danendra Nayaka Passadhi
- Muhammad Dhia Ramadhanil Haq

### [⬅️Back to Repo](../../)

<br>

## 🗺️Flowchart

```mermaid

flowchart TD
    
    %% Fungsi
    %% -------- Saran Judul
    FungsiSaranJudul(["Fungsi saranJudul(String cariBuku, String[][] arrayData)"]) --> cekKataMirip["Mengecek Kata yang Mirip"]
    cekKataMirip -- IF TRUE --> outputTampilJudulMirip[/"Tampil Judul yang Mirip"/]
    outputTampilJudulMirip --> returnFungsiSaranJudul(["return"])
    cekKataMirip -- IF FALSE --> outputBukuTidakDitemukan[/"Output Buku Tidak Ditemukan!"/]
    outputBukuTidakDitemukan --> returnFungsiSaranJudul
    %% -------- Cari Buku
    FungsiCariNamaBuku(["Fungsi cariBuku(String cariBuku, int i)"]) --> inputCariNamaBuku[/"Memasukkan Input Nama Buku"/]
    inputCariNamaBuku -- IF FALSE --> tampilSaranJudul[["saranJudul"]]
    tampilSaranJudul --> returnTrue(["return true"])
    inputCariNamaBuku -- IF TRUE --> rekursifCariTiapBuku["Mencocokan Tiap Buku"]
    rekursifCariTiapBuku -- IF FALSE --> returnFungsiCariNamaBuku[["return cariBuku"]]
    rekursifCariTiapBuku -- IF TRUE --> tampilHasilBuku[/"Menampilkan Hasil Buku"/]
    tampilHasilBuku --> returnFalse(["return false"])
    %% -------- Input No Buku
    FungsiInputNoBuku(["Fungsi inputNoBuku()"]) --> InputNoBukuUser[/"Memasukkan Input noBuku"/]
    InputNoBukuUser --> returnFungsiInputNoBuku(["return noBuku"])
    %% -------- Menampilkan Buku
    FungsiMenampilkanBuku(["Fungsi TampilBuku()"]) --> MenampilkanListBuku2[/"Menampilkan List buku"/] --> returnFungsiMenampilkanBuku(["return"])
    %% -------- Tambah Buku
    FungsiTambahBuku(["Fungsi tambahBuku(int pilihan)"]) --> InputJumlahBuku[/"Input Jumlah Buku"/]
    InputJumlahBuku --> Simpan["Tambah Stock Buku Disimpan"]
    Simpan --> returnFungsiTambahBuku(["return"])
    %% -------- Kurangi Buku
    FungsiKurangiBuku(["Fungsi kurangiBuku(int pilihan)"]) --> InputJumlahBuku2[/"Input Jumlah Buku"/]
    InputJumlahBuku2 --> Simpan2["Kurang Stock Buku Disimpan"]
    Simpan2 --> returnFungsiKurangiBuku(["return"])

    START(["START"]) --> DecLogReg["
        Verification
        1] Login
        2] Register

        0] Exit Program
    "]

    %% 0] Exit Program
    DecLogReg --if 0--> END(["END"])

    %% 2] Register
    DecLogReg --if 2--> Register["Do Register"]
    Register --> Login

    %% 1] Login
    DecLogReg --if 1--> Login["Do Login"]
    Login --> Menu["Menu:
        1] Peminjaman Buku
        2] Pengembalian Buku
        3] Manajemen Buku
        4] Pencarian Buku
        5] Buku Digital
        6] Pengelolaan Stok Buku

        0] Logout
    "]

    %% 0] Logout
    Menu -- 0 --> DecLogReg

    %% 1] Peminjaman Buku
    Menu -- if 1 --> PeminjamanBuku["Peminjaman Buku"]
    PeminjamanBuku --> JumlahStockAwal[/"Menampilkan Jumlah Stock Awal"/]
    JumlahStockAwal --> InputJumlahMeminjam[/"Input Jumlah Meminjam Buku"/]
    InputJumlahMeminjam --> ProsesMeminjamBuku["Proses Mengurangi Buku"]
    ProsesMeminjamBuku --> JumlahStockAkhir[/"Menampilkan jumlah Stock Akhir"/]
    JumlahStockAkhir --> Point((" "))

    %% 2] Pengembalian Buku
    Menu -- if 2 --> PengembalianBuku["Pengembalian Buku"]
    PengembalianBuku --> JumlahStockAwal2[/"Menampilkan Jumlah Stock Awal"/]
    JumlahStockAwal2 --> InputJumlahMengembalikan[/"Input Jumlah Pengembalian Buku"/]
    InputJumlahMengembalikan --> ProsesMengembalikanBuku["Proses Menambah Buku"]
    ProsesMengembalikanBuku --> JumlahStockAkhir2[/"Menampilkan jumlah Stock Akhir"/]
    JumlahStockAkhir2 --> Point((" "))

    %% 3] Manajemen Buku
    Menu -- if 3 --> ManajemenBuku["Manajemen Buku"]
    ManajemenBuku --> ListBuku[/"List Buku\n(show list buku)"/]
    ListBuku --> MenuManajemenBuku["
        1] Menambahkan Buku Baru
        2] Mengubah Buku
        3] Menghapus Buku

        0] Batalkan
    "]
        %% Batalkan
        MenuManajemenBuku -- if 0 --> Point((" "))
        %% Menambah Buku Baru
        MenuManajemenBuku -- if 1 --> MenambahBukuBaru["Do - Menambah Buku Baru"]
        MenambahBukuBaru --> ListBukuFinal[/"Show List Buku (update)"/]
        ListBukuFinal --> Point((" "))
        %%Mengubah Buku
        MenuManajemenBuku -- if 2 --> MengubahBuku["Do - Mengubah Buku"]
        MengubahBuku --> ListBukuFinal2[/"Show List Buku (update)"/]
        ListBukuFinal2 --> Point((" "))
        %%Menghapus Buku
        MenuManajemenBuku -- if 3 --> MenghapusBuku["Do - Menghapus Buku"]
        MenghapusBuku --> ListBukuFinal3[/"Show List Buku (update)"/]
        ListBukuFinal3 --> Point((" "))
    
    %% 4] Pencarian Buku
    Menu -- if 4 --> PencarianBuku["Pencarian Buku"]
    PencarianBuku --> MencariBuku[["cariBuku"]]
    MencariBuku --> HasilBukuTemuan[/"Menampilkan Hasil Buku"/]
    HasilBukuTemuan --> Point((" "))

    %% 5] Buku Digital
    Menu -- if 5 --> BukuDigital["Buku Digital"]
    BukuDigital --> MenampilkanTipeBuku[/"Menampilkan Tipe Buku"/]
    MenampilkanTipeBuku -->  MemilihTipeBuku["Memilih Tipe Buku"]
    MemilihTipeBuku --> TampilkananBuku[/"Menampilkan Buku Berupa wujud Link"/]
    TampilkananBuku --> Point((" "))
    
    %% 6] Pengelolaan Stok Buku
    Menu -- if 6 --> PengelolaanStockBuku["Pengelolaan Stock Buku"]
    PengelolaanStockBuku --> MenuPengelolaanStockBuku["
        1. Tampilkan buku tersedia
        2. Tambah buku
        3. Kurang buku
    "]
    MenuPengelolaanStockBuku --> InputNoBuku[["inputNoBuku"]]

        %% Tampilkan buku tersedia
        InputNoBuku -- if 1 --> MenampilkanBuku[["TampilBuku"]] --> Point((" "))
        %% Tambah Buku
        InputNoBuku -- if 2 --> TambahBuku[["tambahBuku"]]
        TambahBuku --> Point((" "))
        %% Kurang Buku
        InputNoBuku -- if 3 --> KurangBuku[["kurangBuku"]]
        KurangBuku --> Point((" "))


    %% Action after Point
    Point --> Validation["
        Apakah anda ingin kembali ke menu?
        1] Ya
        2] Tidak(logout)
    "]

    %% 1] Ya
    Validation -- If 1 --> Menu

    %% 2] Tidak(logout)
    Validation -- If 2 --> DecLogReg



```

<br>
<br>
<br>

<h1 align="center">
    <a href="#top">⏏️Back to Top</a>
</h1>
