import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garden{
    private List<Plant> plants;
    private String layoutName;
    private Scanner scanner;

    public Garden(String layoutName) {
        this.layoutName = layoutName;
        this.plants = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addPlant() {
        System.out.println("\n*** Tambah Tanaman Baru ***");
        System.out.print("Masukkan nama tanaman: ");
        String plantName = scanner.nextLine();

        System.out.print("Masukkan nama ilmiah tanaman: ");
        String scientificName = scanner.nextLine();

        System.out.print("Masukkan usia tanaman (dalam tahun): ");
        int age = getIntInput();

        System.out.println("Pilih jenis tanaman:");
        System.out.println("1. Tanaman Hias");
        System.out.println("2. Tanaman Obat");
        System.out.println("3. Tanaman Sayur");
        System.out.print("> ");
        int type = getIntInput();

        Plant plant;

        switch (type) {
            case 1:
                plant = new DecorativePlants(plantName, scientificName, age);
                break;
            case 2:
                plant = new MedicinalPlants(plantName, scientificName, age);
                break;
            case 3:
                plant = new VegetablePlants(plantName, scientificName, age);
                break;
            default:
                System.out.println("Jenis tanaman tidak valid. Menambahkan sebagai tanaman biasa.");
                plant = new Plant(plantName, scientificName, age);
                break;
        }

        plants.add(plant);
        System.out.println("Tanaman " + plantName + " berhasil ditambahkan ke taman!.");

    }

    public void displayAllPlants() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman di taman.");
            return;
        }

        System.out.println("\n=== Daftar Semua Tanaman di Taman: " + layoutName + " ===");
        for (Plant plant : plants) {
            System.out.println(plant.checkHealth());
            System.out.println("-----------------------------------");
        }
    }

    public void updatePlantGrowth() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman di taman.");
            return;
        }

        System.out.println("\n*** Update Pertumbuhan Tanaman ***");

        for (Plant plant : plants) {
            System.out.println("\nMemperbarui tanaman: " + plant.plantName);

            plant.grow(0);      // User memilih pupuk/vitamin di dalam method grow()
            plant.water(false);     // User memilih siram/tidak di dalam method water()
            plant.weather(0);   // User memilih cuaca di dalam method weather()
        }
    }

    private int getIntInput(){
        while (!scanner.hasNextInt()) {
            System.out.print("Input tidak valid. Silakan masukkan angka: ");
            scanner.next(); 
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline
        return input;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }
}