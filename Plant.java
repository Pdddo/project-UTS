import java.util.Scanner;

public class Plant {
    Scanner sc = new Scanner(System.in);
    protected String name;
    protected String scientificName;
    protected int age;
    protected String status;

    protected int hydration;
    protected int nutrition;
    protected int sunlight;

    public Plant(String name, String scientificName, int age) {
        this.name = name;
        this.scientificName = scientificName;
        this.age = age;
        this.status = "Layu";
        this.hydration = 0;
        this.nutrition = 0;
        this.sunlight = 0;
    }

    public void grow(int type) {
        do {
            System.out.println("Pilih opsi untuk tambahan nutrisi :");
            System.out.println("1. Pupuk");
            System.out.println("2. Vitamin");
            System.out.println("> ");

            while (!sc.hasNextInt()) {
                System.out.println("Input harus angka");
                sc.next();
            }

            type = sc.nextInt();
            if (type == 1) {
                this.nutrition += 10;
                System.out.println("Pupuk telah ditambahkan. Nutrisi bertambah 10 exp");
            } else if (type == 2) {
                this.nutrition += 20;
                System.out.println("Vitamin telah ditambahkan. Nutrisi bertambah 20 exp");
            } else {
                System.out.println("Pilih angka antara 1 atau 2");
            }
        } while (type != 1 && type != 2);
        
        updateStatus();
    }

    public void water(int choice) {
        do {
            System.out.println("Apakah ingin menyiram tanaman?");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            System.out.println("> ");
        
            while (!sc.hasNextInt()) {
                System.out.println("Input harus angka");
                sc.next();
            }

            choice = sc.nextInt();

            if (choice == 1) {
                this.hydration += 5;
                System.out.println("Tanaman berhasil disiram. Nutrisi bertambah 5 exp");
            } else if (choice == 2) {
                this.hydration += 0;
                System.out.println("Tanaman tidak disiram");
            } else {
                System.out.println("Pilih angka antara 1 atau 2");
            }
        } while (choice != 1 && choice != 2);

        updateStatus();
    }

    public void weather(int todayWeather) {
        do {
            System.out.println("Bagaimana cuaca hari ini?");
            System.out.println("1. Cerah");
            System.out.println("2. Mendung");
            System.out.println("3. Hujan");
            System.out.println("> ");

            while (!sc.hasNextInt()) {
                System.out.println("Input harus angka");
                sc.next();
            }

            todayWeather = sc.nextInt();

            if (todayWeather == 1) {
                this.sunlight += 5;
                System.out.println("Hari ini cerah! Nutrisi tanaman mu bertambah 5 exp");
            } else if (todayWeather == 2) {
                this.sunlight += 2;
                System.out.println("Waduh lagi mendung nih. Tanaman  mu bertambah 2 exp");
            } else if (todayWeather == 3) {
                this.sunlight += 0;
                System.out.println("YAHHH HUJAN. Tanaman mu kekurangan cahaya matahari");
            } else {
                System.out.println("Pilih angka antara 1, 2 dan 3");
            }
        } while (todayWeather < 1 || todayWeather > 3);

        updateStatus();
    }
    
    public void updateStatus() {
        if (nutrition >= 15 && hydration >= 5 && sunlight >= 5) {
            status = "Sehat";
        } else if (nutrition >= 10 && hydration >= 5 && sunlight >= 2) {
            status = "Cukup sehat";
        } else {
            status = "Layu";
        }
    }

    public String checkHealth() {
        return "Nama Tanaman : " + name + 
                "\nNama Ilmiah : " + scientificName +
                "\nUsia : " + age + " tahun" +
                "\nStatus Kesehatan : " + status +
                "\nNutrition : " + nutrition +
                "\nHydration : " + hydration +
                "\nSunlight : " + sunlight;
    }

    
}


class decorativePlants extends Plant {
    public decorativePlants(String name, String scientificName, int age) {
        super(name, scientificName, age);
    }
}

class medicinalPlants extends Plant {
    public medicinalPlants(String name, String scientificName, int age) {
        super(name, scientificName, age);
    }
}

class  vegetablePlants extends Plant {
    public vegetablePlants(String name, String scientificName, int age) {
        super(name, scientificName, age);
    }
}
