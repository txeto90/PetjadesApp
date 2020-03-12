package model;

public class Animal {
    private String vulgarName;
    private String scientificName;
    private String description;
    private String habitat;
    private int image;
    //private image distribution
    //private algo traces (rastres)

    public Animal(){}

    public Animal(String vulgarName, String scientificName, String description, String habitat, int image) {
        this.vulgarName = vulgarName;
        this.scientificName = scientificName;
        this.description = description;
        this.habitat = habitat;
        this.image = image;
    }
    public Animal(String vulgarName, String scientificName, int image) {
        this.vulgarName = vulgarName;
        this.scientificName = scientificName;
        this.image = image;
    }

    public String getVulgarName() {
        return vulgarName;
    }

    public void setVulgarName(String vulgarName) {
        this.vulgarName = vulgarName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
