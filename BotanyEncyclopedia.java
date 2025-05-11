import java.util.Scanner;

public class BotanyEncyclopedia {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Berapa banyak tanaman hias yang ingin ditambahkan? ");
            int jumlahTanaman = input.nextInt();
            input.nextLine();  

            TanamanHias[] tanamanHias = new TanamanHias[jumlahTanaman];

            for (int i = 0; i < jumlahTanaman; i++) {
                System.out.println("\nMenambahkan Tanaman Hias ke-" + (i + 1));

                System.out.print("Nama Tanaman: ");
                String namaTanaman = input.nextLine();
                System.out.print("Kategori Tanaman (e.g., Bunga, Foliase): ");
                String kategori = input.nextLine();
                System.out.print("Apakah cocok untuk dalam ruangan? (true/false): ");
                boolean indoor = input.nextBoolean();
                input.nextLine();  
                System.out.print("Preferensi Cahaya: ");
                String cahaya = input.nextLine();

                TanamanHias tanaman = new TanamanHias(namaTanaman, kategori, indoor, cahaya);
                System.out.print("Nama Ilmiah Tanaman: ");
                tanaman.setScientificName(input.nextLine());

                tanamanHias[i] = tanaman;
            }

            System.out.println("\nInformasi Tanaman Hias yang Ditambahkan:");
            for (TanamanHias tanaman : tanamanHias) {
                tanaman.describe();
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
