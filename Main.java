import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player("Player1", "Default Pot", "Default Background");

        System.out.println("=== Selamat datang di Botany Terminal Project ===");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah tanaman ke taman");
            System.out.println("2. Tampilkan taman milik player");
            System.out.println("3. Informasi tanaman berdasarkan tipe");
            System.out.println("4. Informasi tanaman berdasarkan nama");
            System.out.println("5. Menumbuhkan tanaman di taman");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, silakan masukkan angka 1-6.");
                continue;
            }

            switch (choice) {
                case 1:
                    player.addPlantMenu();
                    break;

                case 2:
                    player.showGarden();
                    break;

                case 3:
                    System.out.print("Masukkan tipe tanaman (hias, obat, sayur): ");
                    String type = scanner.nextLine();
                    String infoByType = BotanyEncyclopedia.getInfoByType(type);
                    System.out.println(infoByType);
                    break;

                case 4:
                    System.out.print("Masukkan nama tanaman: ");
                    String name = scanner.nextLine();
                    String infoByName = BotanyEncyclopedia.getInfoByName(name);
                    System.out.println(infoByName);
                    break;

                case 5:
                    List<Plant> plants = player.getGarden().getPlants();
                    if (plants.isEmpty()) {
                        System.out.println("Taman masih kosong, tidak ada tanaman untuk ditumbuhkan.");
                        break;
                    }

                    System.out.println("Pilih tanaman yang ingin ditumbuhkan:");
                    for (int i = 0; i < plants.size(); i++) {
                        Plant p = plants.get(i);
                        System.out.println((i + 1) + ". " + p.getName());
                    }
                    System.out.print("Masukkan nomor tanaman: ");

                    int plantChoice = -1;
                    try {
                        plantChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid.");
                        break;
                    }

                    if (plantChoice < 1 || plantChoice > plants.size()) {
                        System.out.println("Pilihan tanaman tidak valid.");
                        break;
                    }

                    Plant selectedPlant = plants.get(plantChoice - 1);
                    selectedPlant.grow();  // Memanggil method grow() dari Plant
                    System.out.println("Tanaman '" + selectedPlant.getName() + "' telah tumbuh!");
                    System.out.println("Status pertumbuhan: " + selectedPlant.getGrowthStatus());
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan pilih antara 1 sampai 6.");
            }
        }

        scanner.close();
    }
}
