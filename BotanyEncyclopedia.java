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
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (1-3): ");
            String pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tambahTanaman();
                    break;
                case "2":
                    showAllPlants();
                    break;
                case "0":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Ensiklopedia Tanaman!");
                    break;
                default:
                    System.out.println("❌ Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }

    private void tambahTanaman() {
        try {
            System.out.println("\n--- Tambah Tanaman Hias Baru ---");

            String namaTanaman = inputText("Nama Tanaman (huruf saja, tidak boleh kosong): ");
            String namaIlmiah = inputText("Nama Ilmiah Tanaman (huruf saja, tidak boleh kosong): ");
            String kategori = inputText("Kategori Tanaman (e.g., Bunga, Foliase): ");
            boolean indoor = inputBoolean("Apakah cocok untuk dalam ruangan? (true/false): ");

            String cahaya;
            while (true) {
                System.out.print("Preferensi Cahaya: ");
                cahaya = input.nextLine().trim();

                if (cahaya.isEmpty()) {
                    System.out.println("❌ Input tidak boleh kosong.");
                } else if (!cahaya.matches("\\d+")) {
                    System.out.println("❌ Input hanya boleh berupa angka bulat positif (tanpa huruf atau simbol).");
                } else {
                    break;
                }
            }

            TanamanHias tanaman = new TanamanHias(namaTanaman, namaIlmiah, kategori, indoor, cahaya);
            tanamanList.add(tanaman);
            System.out.println("\n✅ Tanaman berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("\n❌ Terjadi kesalahan: " + e.getMessage());
        }
    }

    private String inputText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputStr = input.nextLine().trim();

            if (inputStr.isEmpty()) {
                System.out.println("❌ Input tidak boleh kosong.");
            } else if (!inputStr.matches("[a-zA-Z\\s]+")) {
                System.out.println("❌ Input hanya boleh huruf dan spasi.");
            } else {
                return inputStr;
            }
        }
    }

    private boolean inputBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String boolStr = input.nextLine().trim().toLowerCase();

            if (boolStr.equals("true")) return true;
            if (boolStr.equals("false")) return false;

            System.out.println("❌ Masukkan hanya 'true' atau 'false'.");
        }
    }

    // Menampilkan semua tanaman yang sudah dimasukkan
    public void showAllPlants() {
        if (tanamanList.isEmpty()) {
            System.out.println("Belum ada tanaman dalam ensiklopedia.");
            return;
        }

        System.out.println("\n=== Daftar Tanaman dalam Ensiklopedia ===");
        for (TanamanHias tanaman : tanamanList) {
            tanaman.describe();
        }
    }
}
