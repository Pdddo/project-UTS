import java.util.Scanner;

public class Player{
    private String playerName;
    private Garden garden;
    private Scanner scanner;

    public Player(String playerName) {
        this.playerName = playerName;
        // this.garden = new Garden("Taman " + playerName);
        this.scanner = new Scanner(System.in);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n=== Menu Pemain: " + playerName + " ===");
            System.out.println("1. Tambah Tanaman");
            System.out.println("2. Lihat Semua Tanaman");
            System.out.println("3. Update Pertumbuhan Tanaman");
            System.out.println("4. Buka Ensiklopedia Botani");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("> ");

            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid. Masukkan angka: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // hapus newline

            switch (choice) {
                case 1:
                    garden.addPlant();
                    break;
                case 2:
                    garden.displayAllPlants();
                    break;
                case 3:
                    garden.updatePlantGrowth();
                    break;
                case 4:
                    openEncyclopedia();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    private void openEncyclopedia() {
        System.out.println("\n=== Ensiklopedia Botani ===");
        System.out.print("Masukkan jenis tanaman (hias, obat, sayur) atau nama tanaman: ");
        String input = scanner.nextLine().toLowerCase();

        if (input.equals("hias") || input.equals("obat") || input.equals("sayur")) {
            System.out.println(BotanyEncyclopedia.getInfoByType(input));
        } else {
            System.out.println(BotanyEncyclopedia.getInfoByName(input));
        }
    }
}