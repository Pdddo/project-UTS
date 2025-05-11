import java.util.Scanner;
public abstract class Plant {
    Scanner input = new Scanner(System.in);
    protected String plantName;
    protected String scientificName;
    protected double age;
    protected String status;

    protected int hydration;
    protected int nutrition;
    protected int sunlight;

    public Plant(String plantName) {
        this.plantName = plantName;
    }

    public Plant(String plantName, String scientificName, int age) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.age = age;
        this.status = "Layu";
        this.hydration = 0;
        this.nutrition = 0;
        this.sunlight = 0;
    }

    public void setPlantName (String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName () {
        return plantName;
    }

    public void grow(int type) {
        type = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n Selamat datang di menu Pertumbuhan");
                System.out.println("Pilih opsi penunjang pertumbuhan: ");
                System.out.println("1. Pupuk");
                System.out.println("2. Vitamin");
                System.out.print("> ");
                type = Integer.parseInt(input.nextLine());

                if (type == 1) {
                    this.nutrition += 10;
                    validInput = true;
                    System.out.println("Tanaman telah diberi pupuk! Nutrisi tanaman mu +10");
                } else if (type == 2) {
                    this.nutrition += 20;
                    validInput = true;
                    System.out.println("Tanaman telah diberi vitamin!");
                } else {
                    System.out.println("Opsi tidak tersedia. Silahkan coba lagi!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka antara 1 atau 2");
            }
        }
        updateStatus();
    }

    public void water(boolean validInput) {
        validInput = false;
        while (!validInput) {
            System.out.println("\nSelamat datang di menu Penyiraman");
            System.out.println("Mau menyiram tanaman? [y/n]");
            System.out.print("> ");
            String isWatered = input.nextLine();

            if (isWatered.equalsIgnoreCase("y")) {
                this.hydration += 5;
                validInput = true;
                System.out.println("Tanaman telah disiram. Hidrasi +5");
            } else if (isWatered.equalsIgnoreCase("n")){
                validInput = true;
                System.out.println("Tanaman belum disiram...");
            } else {
                System.out.println("Masukkan hanya [y] atau [n] ");
            }
        }
        updateStatus();
    }

    public void weather(int weatherType) {
        weatherType = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n Cek cuaca hari ini: ");
                System.out.println("1. Cerah");
                System.out.println("2. Mendung");
                System.out.println("3. Hujan");
                System.out.print("> ");
                weatherType = Integer.parseInt(input.nextLine());

                switch (weatherType) {
                    case 1:
                        sunlight += 5;
                        validInput = true;
                        System.out.println("Wah!! Cerah benderang, Tanaman siap tumbuh.");
                        break;
                    case 2:
                        sunlight += 2;
                        validInput = true;
                        System.out.println("Aduh.. mendung, semoga tanamannya gakk kekurangan cahaya matahari");
                        break;
                    case 3:
                        sunlight += 0;
                        validInput = true;
                        System.out.println("Waduhh hujann. Tanaman gak dapet cahaya matahari T_T");
                        break;
                    default:
                        System.out.println("hmm.. cuacanya gak jelas, input ulang yah!");
                        break;
                        }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan antara 1/2/3");
            }
        }
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

    public void updateAge() {
        age = 0;
        if (status.equalsIgnoreCase("Sehat")) {
            age += 1;
        } else if (status.equalsIgnoreCase("Cukup sehat")) {
            age += 0.5;
        }
    }

    public String checkHealth() {
        return  "\n STATUS KESEHATAN TANAMAN" + // neh ada garis kuningnya
        "\nNama Tanaman: " + plantName +
        "\nNama Ilmiah: " + scientificName +
        "\nUsia : " + age + 
        "\nStatus: " + status +
        "\nNutrition: " + nutrition +
        "\n Hydration: " + hydration +
        "\nSunlight: " + sunlight;

    }

} 

class DecorativePlants extends Plant{
    public DecorativePlants(String plantName) {
        super(plantName, "", 0);
    }
    public DecorativePlants(String plantName, String scientificName, int age) {
        super(plantName, scientificName, age);
    }

    public void inputDetail() {
        System.out.println("Masukkan nama ilmiah tanaman hias: ");
        this.scientificName = input.nextLine();
    }
}

class MedicinalPlants extends Plant{
    public MedicinalPlants(String plantName) {
        super(plantName, "", 0);
    }

    public MedicinalPlants(String plantName, String scientificName, int age) {
        super(plantName, scientificName, age);
    }

    public void inputDetail() {
        System.out.println("Masukkan nama ilmiah tanaman obat: ");
        this.scientificName = input.nextLine();
    }
}


class VegetablePlants extends Plant {
    public VegetablePlants(String plantName) {
        super(plantName, "", 0);
    }

    public VegetablePlants(String plantName, String scientificName, int age) {
        super(plantName, scientificName, age);
    }

    public void inputDetail() {
        System.out.println("Masukkan nama ilmiah tanaman sayur: ");
        this.scientificName = input.nextLine();
    }
}


