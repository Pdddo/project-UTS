import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Garden extends Plant{
    private List<Plant> plants;

    private String layoutName;
    private Scanner scanner;

    // Membuat taman berdasarkan nama layout
    public Garden(String layoutName) {
        super(layoutName);
        this.layoutName = layoutName;
        this.plants = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Membuat taman dan tanaman awal
    public Garden(String plantName, String scientificName, int age, String layoutName) {
        super(plantName, scientificName, age);
        this.layoutName = layoutName;
        this.plants = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method untuk menambahkan tanaman baru ke taman
    public void addPlant() {
        try {
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

            // Menentukan jenis tanaman dan menambahkannya ke daftar tanaman
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
                    System.out.println("Jenis tanaman tidak valid.");
                    return;
            }

            plants.add(plant);
            System.out.println("Tanaman " + plantName + " berhasil ditambahkan ke taman!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan tanaman: " + e.getMessage());
        }
    }

    // Menampilkan semua tanaman yang ada di taman
    public void displayAllPlants() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman di taman.");
            return;
        }

        System.out.println("\n=== Daftar Semua Tanaman di Taman: " + layoutName + " ===");
        for (Plant plant : plants) {
            try {
                System.out.println(plant.checkHealth());
                System.out.println("-----------------------------------");
            } catch (Exception e) {
                System.out.println("Gagal menampilkan informasi tanaman: " + e.getMessage());
            }
        }
    }

    // Mengupdate pertumbuhan semua tanaman secara serentak
    public void updatePlantGrowth() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman di taman.");
            return;
        }

        System.out.println("\n*** Update Pertumbuhan Tanaman ***");

        for (Plant plant : plants) {
            try {
                System.out.println("\nMemperbarui tanaman: " + plant.plantName);
                plant.grow(0);
                plant.water(false);
                plant.weather(0);
            } catch (Exception e) {
                System.out.println("Gagal memperbarui tanaman " + plant.plantName + ": " + e.getMessage());
            }
        }
    }

    // Memberi aksi pada tanaman tertentu (grow, water, weather)
    public void actionPlant() {
        if (plants.isEmpty()) {
            System.out.println("Belum ada tanaman untuk dipilih.");
            return;
        }

        try {
            System.out.println("Pilih nomor tanaman:");
            for (int i = 0; i < plants.size(); i++) {
                Plant p = plants.get(i);
                System.out.printf("%d. %s\n", i + 1, p.getPlantName());
            }
            System.out.print("Nomor tanaman: ");
            int plantChoiceStr = getIntInput();

            if (plantChoiceStr < 1 || plantChoiceStr > plants.size()) {
                System.out.println("Pilihan tidak valid.");
                return;
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
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harus berupa angka.");
            scanner.nextLine(); // Clear input buffer
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat melakukan aksi tanaman: " + e.getMessage());
        }
    }

    // Membantu agar input yang diminta adalah integer
    private int getIntInput() {
        while (true) {
            try {
                String inputStr = scanner.nextLine();
                return Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Silakan masukkan angka: ");
            }
        }
    }

    // Getter untuk daftar tanaman 
    public List<Plant> getPlants() {
        return plants;
    }

    // Getter untuk nama layout taman
    public String getLayoutName() {
        return layoutName;
    }

    // Setter untuk nama layout taman
    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }
}
