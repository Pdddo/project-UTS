public abstract class Plant {
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
        switch (weatherType) {
            case 1:
                sunlight += 5;
                break; //cerah
            case 2:
                sunlight += 2;
                break; //mendung
            case 3:
                sunlight += 0;
                break; //hujan
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
        return "Nama Tanaman : " + name + 
                "\nNama Ilmiah : " + scientificName +
                "\nUsia : " + age + " tahun" +
                "\nStatus Kesehatan : " + status +
                "\nNutrition : " + nutrition +
                "\nHydration : " + hydration +
                "\nSunlight : " + sunlight;
    }

    
}

// class decorativePlants extends Plant {
//     public decorativePlants(String name, String scientificName, int age) {
//         super(name, scientificName, age);
//     }
// }

// class medicinalPlants extends Plant {
//     public medicinalPlants(String name, String scientificName, int age) {
//         super(name, scientificName, age);
//     }
// }

// class  vegetablePlants extends Plant {
//     public vegetablePlants(String name, String scientificName, int age) {
//         super(name, scientificName, age);
//     }
// }
