import java.util.Scanner;

public class Player implements IDescribable, ICategorizable, Indoorable {
    private String playerName;
    private String category;
    private boolean suitableForIndoor;
    private Garden garden;
    private Scanner scanner = new Scanner(System.in);

    public Player(String playerName){
        this.playerName = playerName;
    }

    public Player(String name, String category, boolean suitableForIndoor, Garden garden) {
        this.playerName = name;
        this.category = category;
        this.suitableForIndoor = suitableForIndoor;
        this.garden = garden;
    }

    // Implementasi IDescribable
    @Override
    public void describe() {
        System.out.println("Nama Player: " + playerName);
        System.out.println("Kategori: " + category);
        System.out.println("Cocok untuk indoor: " + (suitableForIndoor ? "Ya" : "Tidak"));
        if (garden != null) {
            System.out.println("Memiliki taman: " + garden.getName());
        } else {
            System.out.println("Belum memiliki taman.");
        }
    }

    // Implementasi ICategorizable
    @Override
    public String getCategoryName() {
        return category;
    }

    // Implementasi Indoorable
    @Override
    public boolean isSuitableForIndoor() {
        return suitableForIndoor;
    }

    public String getName() {
        return playerName;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public void showGarden() {
        if (garden != null) {
            System.out.println("Informasi taman milik " + playerName + ":");
            System.out.println("- Nama taman: " + garden.getName());
        } else {
            System.out.println(playerName + " belum memiliki taman.");
        }
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n=== Menu Pemain: " + playerName + " ===");
            System.out.println("1. Tambah tanaman");
            System.out.println("2. Lihat semua tanaman");
            System.out.println("3. Pilih tanaman untuk aksi");
            System.out.println("4. Update pertumbuhan tanaman");
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
                    if (garden != null) garden.addPlant();
                    break;
                case 2:
                    if (garden != null) garden.displayAllPlants();
                    break;
                case 3:
                    if (garden != null) garden.actionPlant();
                    break;
                case 4:
                    if (garden != null) garden.updatePlantGrowth();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }
}



// import java.util.Scanner;

// public class Player implements IDescribable {
//     private String playerName;
//     private Garden garden;
//     private Scanner scanner;

//     public Player(String playerName) {
//         this.playerName = playerName;
//         this.garden = new Garden("Taman " + playerName);
//         this.scanner = new Scanner(System.in);
//     }

//     public String getPlayerName() {
//         return playerName;
//     }

//     @Override
//     public void describe() {
//         System.out.println("Pemain: " + playerName);
//         System.out.println("Memiliki taman bernama: " + garden.getName());
//     }

//     public void showMenu() {
//         int choice;

//         do {
//             System.out.println("\n=== Menu Pemain: " + playerName + " ===");
//             System.out.println("1. Tambah tanaman");
//             System.out.println("2. Lihat semua tanaman");
//             System.out.println("3. Pilih tanaman untuk aksi");
//             System.out.println("4. Update pertumbuhan tanaman");
//             System.out.println("5. Buka ensiklopedia botani");
//             System.out.println("0. Kembali ke menu utama");
//             System.out.print("> ");

//             while (!scanner.hasNextInt()) {
//                 System.out.print("Input tidak valid. Masukkan angka: ");
//                 scanner.next();
//             }

//             choice = scanner.nextInt();
//             scanner.nextLine(); // hapus newline

//             switch (choice) {
//                 case 1:
//                     garden.addPlant();
//                     break;
//                 case 2:
//                     garden.displayAllPlants();
//                     break;
//                 case 3:
//                     garden.actionPlant();
//                     break;
//                 case 4:
//                     garden.updatePlantGrowth();
//                     break;
//                 case 5:
//                     openEncyclopedia();
//                     break;
//                 case 0:
//                     System.out.println("Kembali ke menu utama...");
//                     break;
//                 default:
//                     System.out.println("Pilihan tidak valid.");
//             }
//         } while (choice != 0);
//     }

//     private void openEncyclopedia() {
//         System.out.println("\n=== Ensiklopedia Botani ===");
//         System.out.print("Masukkan jenis tanaman (hias, obat, sayur): ");
//         String input = scanner.nextLine().toLowerCase();

//         if (input.equals("hias") || input.equals("obat") || input.equals("sayur")) {
//             System.out.println(BotanyEncyclopedia.getInfoByType(input));
//         } else {
//             System.out.println(BotanyEncyclopedia.getInfoByName(input));
//         }
//     }
// }
