package model;

public class Animal {
    private String scientificName;
    private String vulgarName;
    private String description;
    private String habitat;
    private String distribution;
    private String trace;
    private String imgExcrement;
    private String imgFootprint;
    private String imgTraces;
    private String imgAnimal;

    public Animal(){}

/*    public Animal(String vulgarName, String scientificName, String description, String habitat, String image) {
        this.vulgarName = vulgarName;
        this.scientificName = scientificName;
        this.description = description;
        this.habitat = habitat;
        this.imgAnimal = image;
    }*/

    public Animal(String scientificName, String vulgarName, String description, String habitat, String distribution,
                  String trace, String imgExcrement, String imgFootprint, String imgTraces, String imgAnimal) {
        this.scientificName = scientificName;
        this.vulgarName = vulgarName;
        this.description = description;
        this.habitat = habitat;
        this.distribution = distribution;
        this.trace = trace;
        this.imgExcrement = imgExcrement;
        this.imgFootprint = imgFootprint;
        this.imgTraces = imgTraces;
        this.imgAnimal = imgAnimal;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getVulgarName() {
        return vulgarName;
    }

    public void setVulgarName(String vulgarName) {
        this.vulgarName = vulgarName;
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

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getImgExcrement() {
        return imgExcrement;
    }

    public void setImgExcrement(String imgExcrement) {
        this.imgExcrement = imgExcrement;
    }

    public String getImgFootprint() {
        return imgFootprint;
    }

    public void setImgFootprint(String imgFootprint) {
        this.imgFootprint = imgFootprint;
    }

    public String getImgTraces() {
        return imgTraces;
    }

    public void setImgTraces(String imgTraces) {
        this.imgTraces = imgTraces;
    }

    public String getImgAnimal() {
        return imgAnimal;
    }

    public void setImgAnimal(String imgAnimal) {
        this.imgAnimal = imgAnimal;
    }
}
