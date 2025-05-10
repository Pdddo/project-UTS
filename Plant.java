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

    //inisialisasi nilai awal
    public Plant(String plantName, String scientificName, int age) {
        this.plantName = plantName;

        this.scientificName = scientificName;
        this.age = age;
        this.status = "Layu";
        this.hydration = 0;
        this.nutrition = 0;
        this.sunlight = 0;
    }

    //setter
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    //getter
    public String getPlantName() {
        return plantName;
    }

    //Method grow() yang memungkinkan user untuk memilih hendak memberikan opsi penunjang pertumbuhan apa (pupuk/vitamin)
    public void grow(int type) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n Selamat datang di menu Pertumbuhan");
                System.out.println("Pilih opsi penunjang pertumbuhan: ");
                System.out.println("1. Pupuk");
                System.out.println("2. Vitamin");
                System.out.println("0. Keluar");
                System.out.print("> ");

                String inputLine = input.nextLine().trim();
                if (inputLine.isEmpty()) {
                    System.out.println("Input tidak boleh kosong!");
                    continue;
                }

                type = Integer.parseInt(inputLine);

                if (type == 1) {
                    this.nutrition += 10;
                    validInput = true;
                    System.out.println("Tanaman telah diberi pupuk! Nutrisi tanaman mu +10");
                } else if (type == 2) {
                    this.nutrition += 20;
                    validInput = true;
                    System.out.println("Tanaman telah diberi vitamin!");
                } else if (type == 0) {
                    validInput = true;
                    System.out.println("Kamu memilih keluar dari menu pertumbuhan");
                } else {
                    System.out.println("Opsi tidak tersedia. Silahkan coba lagi!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka antara 1 atau 2");
            }
        }
        updateStatus();
    }

    //Method water() yang memungkinkan user memilih apakah hendak memberi pupuk kepada tanaman atau tidak
    public void water(boolean validInput) {
        validInput = false;
        while (!validInput) {
            System.out.println("\nSelamat datang di menu Penyiraman");
            System.out.println("Mau menyiram tanaman? [y/n]");
            System.out.print("> ");
            String isWatered = input.nextLine().trim();

            if (isWatered.equalsIgnoreCase("y")) {
                this.hydration += 5;
                validInput = true;
                System.out.println("Tanaman telah disiram. Hidrasi +5");
            } else if (isWatered.equalsIgnoreCase("n")) {
                validInput = true;
                System.out.println("Tanaman belum disiram...");
            } else {
                System.out.println("Masukkan hanya [y] atau [n] ");
            }
        }
        updateStatus();
    }

    //Method weather() yang memungkinkan user untuk menginput kondisi cuaca
    public void weather(int weatherType) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\n Cek cuaca hari ini: ");
                System.out.println("1. Cerah");
                System.out.println("2. Mendung");
                System.out.println("3. Hujan");
                System.out.println("0. Keluar");
                System.out.print("> ");

                String inputLine = input.nextLine().trim();
                if (inputLine.isEmpty()) {
                    System.out.println("Input tidak boleh kosong!");
                    continue;
                }

                weatherType = Integer.parseInt(inputLine);

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
                    case 0:
                        validInput = true;
                        System.out.println("Kamu memilih keluar dari menu cuaca");
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
    
    //Method updateStatus() yang akan mengakumulasi nutrisi, hidrasi dan sunlight dari tanaman lalu mengkategorikannya ke dalam kategori sehat, cukup sehat atau layu
    public void updateStatus() {
        if (nutrition >= 15 && hydration >= 5 && sunlight >= 5) {
            status = "Sehat";
        } else if (nutrition >= 10 && hydration >= 5 && sunlight >= 2) {
            status = "Cukup sehat";
        } else {
            status = "Layu";
        }
    }

    //Method updateAge() merupakan method yang akan mengupdate usia tanaman tergantung kondisi kesehatan
    public void updateAge() {
        if (status.equalsIgnoreCase("Sehat")) {
            age += 1;
            System.out.println("Tanaman mu " + status + ". Usia bertambah!");
        } else if (status.equalsIgnoreCase("Cukup sehat")) {
            age += 0.5;
            System.out.println("Tanaman mu " + status + ". Usia bertambah.");
        } else if (status.equalsIgnoreCase("Layu")) {
            System.out.println("Waduh.. Tanaman mu " + status + ". Cepat rawat tanamanmu!");
        }
    }

    //Method checkHealth() yang akan menampilkan kepada user info serta kondisi kesehatan tanaman
    public String checkHealth() {
        return  "\n STATUS KESEHATAN TANAMAN" + 
        "\nNama Tanaman   : " + plantName +
        "\nNama Ilmiah    : " + scientificName +
        "\nUsia           : " + age + " tahun" +
        "\nStatus         : " + status +
        "\nNutrition      : " + nutrition +
        "\nHydration      : " + hydration +
        "\nSunlight       : " + sunlight;
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


