import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garden extends Plant{
    public List<Plant> plants;
    private String layoutName;
    private Scanner scanner;
    
    public Garden(String layoutName) {
        super(layoutName);
        this.layoutName = layoutName;
        this.plants = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public Garden(String plantName, String scientificName, int age, String layoutName) {
        super(plantName, scientificName, age);
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
                plants.add(plant);
                break;
            case 2:
                plant = new MedicinalPlants(plantName, scientificName, age);
                plants.add(plant);
                break;
            case 3:
                plant = new VegetablePlants(plantName, scientificName, age);
                plants.add(plant);
                break;
            default:
                System.out.println("Jenis tanaman tidak valid");
                break;
        }

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

    public void actionPlant() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman untuk dipilih.");
            // break;
        }
        System.out.println("Pilih nomor tanaman:");
        for (int i = 0; i < plants.size(); i++) {
            Plant p = plants.get(i);
            System.out.printf("%d. %s\n", i + 1, p.getPlantName());
        }
        System.out.print("Nomor tanaman: ");
                int plantChoiceStr = scanner.nextInt();
                // plantChoiceStr = 0;
                try {
                // plantChoice = Integer.parseInt(plantChoiceStr);
                if (plantChoiceStr < 1 || plantChoiceStr > plants.size()) {
                    System.out.println("Pilihan tidak valid.");
                    // break;
                }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka.");
                    // break;
                }
                Plant selectedPlant = plants.get(plantChoiceStr - 1);

                boolean backToMenu = false;
                while (!backToMenu) {
                    System.out.println("\nAksi untuk tanaman: " + selectedPlant.getPlantName());
                    System.out.println("1. Grow");
                    System.out.println("2. Weather");
                    System.out.println("3. Water");
                    System.out.println("4. Kembali ke menu utama");
                    System.out.print("Pilih aksi: ");
                    String action = scanner.nextLine();

                        switch (action) {
                            case "1":
                                // Contoh grow dengan tipe 1, bisa dimodifikasi sesuai kebutuhan
                                selectedPlant.grow(1);
                                System.out.println("Tanaman telah tumbuh.");
                                break;
                            case "2":
                                selectedPlant.weather(1);
                                System.out.println("Cuaca telah mempengaruhi tanaman.");
                                break;
                            case "3":
                                selectedPlant.water(true);
                                System.out.println("Tanaman telah disiram.");
                                break;
                            case "4":
                                backToMenu = true;
                                break;
                            default:
                                System.out.println("Pilihan aksi tidak valid.");
                        }
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