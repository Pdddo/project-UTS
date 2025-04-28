import java.util.ArrayList;
import java.util.List;

public class Garden{
    private List<Plant> plants;
    private String layoutName;

    public Garden(String layoutName) {
        this.layoutName = layoutName;
        this.plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
        
    }
}