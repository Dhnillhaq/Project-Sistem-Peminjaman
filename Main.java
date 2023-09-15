import java.util.Scanner;
/**
 * Main
 */
public class ProjekAkhir {

    public static void main(String[] args) {
        // Deklarasi Scanner untuk input 
        Scanner input = new Scanner(System.in);

        // Deklarasi stok buku akademik
        int stokBukuNonAkademik = 10;

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