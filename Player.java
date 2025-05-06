import java.util.Scanner;

public class Player {
    private String name;
    private Garden garden;

    public Player(String name, String potDesign, String backgroundDesign) {
        this.name = name;
        this.garden = new Garden(name + "'s Garden", potDesign, backgroundDesign);
    }

    public void addPlantMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih jenis tanaman:");
        System.out.println("1. Tanaman Hias");
        System.out.println("2. Tanaman Obat");
        System.out.println("3. Tanaman Sayur");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nama tanaman: ");
        String plantName = scanner.nextLine();

        Plant plant;
        switch (choice) {
            case 1 -> plant = new DecorativePlants(plantName);
            case 2 -> plant = new MedicinalPlants(plantName);
            case 3 -> plant = new VegetablePlants(plantName);
            default -> {
                System.out.println("Pilihan tidak valid.");
                return;
            }
        }

        garden.addPlant(plant);
        System.out.println(plantName + " berhasil ditambahkan ke taman!");
    }

    public void showGarden() {
        System.out.println("\n=== Taman milik " + name + " ===");
        System.out.println("Desain Pot: " + garden.getPotDesign());
        System.out.println("Desain Latar: " + garden.getBackgroundDesign());
        garden.displayGarden();
    }

    public String getName() {
        return name;
    }

    public Garden getGarden() {
        return garden;
    }
}
