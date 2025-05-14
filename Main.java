import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek Player dan Garden
        System.out.print("Masukkan nama pemain: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        System.out.print("Masukkan nama taman: ");
        String gardenName = scanner.nextLine();
        Garden garden = new Garden(gardenName);
        BotanyEncyclopedia ensiklopedia = new BotanyEncyclopedia();

        player.setGarden(garden);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Masuk ke Menu Pemain");
            System.out.println("2. Buka Ensiklopedia");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    player.showMenu();
                    break;
                case "2":
                    ensiklopedia.startEncyclopedia();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan aplikasi taman.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid.");
            }
        }

        scanner.close();
    }
}