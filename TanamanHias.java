public class TanamanHias {
    private String plantName;  
    private String scientificName;  
    private String category;  
    private boolean isIndoor;  
    private String lightPreference;  

    // Konstruktor
    public TanamanHias(String plantName, String scientificName, String category, boolean isIndoor, String lightPreference) {
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.category = category;
        this.isIndoor = isIndoor;
        this.lightPreference = lightPreference;
    }

    // Setter dan Getter
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public String getLightPreference() {
        return lightPreference;
    }

    public void setLightPreference(String lightPreference) {
        this.lightPreference = lightPreference;
    }

    // Menampilkan deskripsi tanaman
    public void describe() {
        System.out.println("Nama Tanaman: " + plantName);
        System.out.println("Nama Ilmiah: " + scientificName);
        System.out.println("Kategori: " + category);
        System.out.println("Cocok untuk dalam ruangan? " + (isIndoor ? "Ya" : "Tidak"));
        System.out.println("Preferensi Cahaya: " + lightPreference);
    }
}
