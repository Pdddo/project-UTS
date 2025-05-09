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

    public Plant(String plantName, String scientificName, int age) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.age = age;
        this.status = "Layu";
        this.hydration = 0;
        this.nutrition = 0;
        this.sunlight = 0;
    }

    public void grow(int type) {
        if (type == 1) {
            this.nutrition += 10;
        } else if (type == 2) {
            this.nutrition += 20;
        }
        updateStatus();
    }

    public void water(boolean isWatered) {
        if (isWatered) {
            this.hydration += 5;
        }
        updateStatus();
    }

    public void weather(int weatherType) {
        if (weatherType == 1) {
            sunlight += 5;
        } else if (weatherType == 2) {
            sunlight += 2;
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


