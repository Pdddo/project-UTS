import java.util.Scanner;
public abstract class Plant {
    Scanner input = new Scanner(System.in);
    protected String plantName;
    protected String scientificName;
    protected int age;
    protected String status;

    protected int hydration;
    protected int nutrition;
    protected int sunlight;

    public Plant(String plantName, String scientificName, int age) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.age = age;
        this.status = "Layu";
        this.hydration = 0;
        this.nutrition = 0;
        this.sunlight = 0;
    }

    public void grow() {
        int type = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n --Pertumbuhan--");
                System.out.println("Pilih opsi penunjang pertumbuhan: ");
                System.out.println("1. Pupuk");
                System.out.println("2. Vitamin");
                System.out.println("> ");
                type = Integer.parseInt(input.nextLine());

                if (type == 1) {
                    this.nutrition += 10;
                    validInput = true;
                    System.out.println("Diberi Pupuk! Nutrisi tanaman mu +10");
                } else if (type == 2) {
                    this.nutrition += 20;
                    validInput = true;
                    System.out.println("Diberi Vitamin! Nutrisi tanaman mu +20");
                } else {
                    System.out.println("Opsi tidak tersedia. Coba lagi!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan antara angka 1 dan 2!");
            }
        }
        updateStatus();
    }

    public void water() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n --Penyiraman--");
            System.out.println("Mau menyiram tanaman hari ini? [Y/N]");
            System.out.println("> ");
            String isWatered = input.nextLine();

            if (isWatered.equalsIgnoreCase("y")) {
                this.hydration += 5;
                validInput = true;
                System.out.println("Tanaman telah disiram. Tingkat Hidrasi +5");
            } else if (isWatered.equalsIgnoreCase("n")){
                validInput = true;
                System.out.println("Tanaman belum disiram hari ini...");
            } else {
                System.out.println("Masukkan hanya [y] atau [n] ");
            }
        }
        updateStatus();
    }

    public void weather() {
        int weatherType = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n Cek cuaca hari ini: ");
                System.out.println("1. Cerah");
                System.out.println("2. Mendung");
                System.out.println("3. Hujan");
                System.out.println("> ");
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

    public String checkHealth() {
        return  "\n STATUS KESEHATAN TANAMAN" +
                "Nama Tanaman : " + plantName + 
                "\nNama Ilmiah : " + scientificName +
                "\nUsia : " + age + " tahun" +
                "\nStatus Kesehatan : " + status +
                "\nNutrition : " + nutrition +
                "\nHydration : " + hydration +
                "\nSunlight : " + sunlight;
    }
}

class decorativePlants extends Plant {
    public decorativePlants(String plantName, String scientificName, int age ) {
        super(plantName, scientificName, age);
    }
}

class medicinalPlants extends Plant {
    public medicinalPlants(String plantName, String scientificName, int age) {
        super(plantName, scientificName, age);
    }
}

class  vegetablePlants extends Plant {
    public vegetablePlants(String plantName, String scientificName, int age) {
        super(plantName, scientificName, age);
    }
}
