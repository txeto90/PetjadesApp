package com.example.petjadesapp.model;

import java.util.Comparator;

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

    public static final Comparator<Animal> VulgarName = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            String vulgarName1 = a1.getVulgarName();
            String vulgarName2 = a2.getVulgarName();
            return vulgarName1.compareTo(vulgarName2);
        }
    };

    public static Comparator<Animal> ScientificName = new Comparator<Animal>() {
        @Override
        public int compare(Animal a1, Animal a2) {
            String scientificName1 = a1.getScientificName();
            String scientificName2 = a2.getScientificName();
            return scientificName1.compareTo(scientificName2);
        }
    };

    public String getScientificName() { return scientificName; }

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
