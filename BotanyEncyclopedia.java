import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BotanyEncyclopedia {
    private Scanner input = new Scanner(System.in);
    private List<TanamanHias> tanamanList = new ArrayList<>();

    public void startEncyclopedia() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Ensiklopedia Tanaman Hias ===");
            System.out.println("1. Tambah Tanaman Hias");
            System.out.println("2. Lihat Semua Tanaman");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    tambahTanaman();
                    break;
                case "2":
                    showAllPlants();
                    break;
                case "3":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Ensiklopedia Tanaman!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }

    private void tambahTanaman() {
        try {
            System.out.println("\n--- Tambah Tanaman Hias Baru ---");

            System.out.print("Nama Tanaman: ");
            String namaTanaman = input.nextLine();
            System.out.print("Nama Ilmiah Tanaman: ");
            String namaIlmiah = input.nextLine();
            System.out.print("Kategori Tanaman (e.g., Bunga, Foliase): ");
            String kategori = input.nextLine();
            System.out.print("Apakah cocok untuk dalam ruangan? (true/false): ");
            boolean indoor = Boolean.parseBoolean(input.nextLine());
            System.out.print("Preferensi Cahaya: ");
            String cahaya = input.nextLine();
            TanamanHias tanaman = new TanamanHias(namaTanaman, namaIlmiah, kategori, indoor, cahaya);
            // System.out.print("Nama Ilmiah Tanaman: ");
            // tanaman.setScientificName(input.nextLine());
            

            tanamanList.add(tanaman);
            System.out.println("\n✅ Tanaman berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("\n❌ Terjadi kesalahan: " + e.getMessage());
        }
    }


    // Menampilkan semua tanaman yang sudah dimasukkan
    public void showAllPlants() {
        if (tanamanList.isEmpty()) {
            System.out.println("Belum ada tanaman dalam ensiklopedia.");
            return;
        }

        for (TanamanHias tanaman : tanamanList) {
            System.out.println("\n=== Daftar Tanaman dalam Ensiklopedia ===");
            tanaman.describe();
        }
    }
}