package com.monzonis.petjadesapp.model;

import java.util.Comparator;

public class Animal {

    private String scientificName;
    private String vulgarName;
    private String description;
    private String habitat;
    private String distribution;
    private String trace;
    private String imgFootprint;
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

    public String getImgFootprint() {
        return imgFootprint;
    }

    public void setImgFootprint(String imgFootprint) {
        this.imgFootprint = imgFootprint;
    }

    public String getImgAnimal() {
        return imgAnimal;
    }

    public void setImgAnimal(String imgAnimal) {
        this.imgAnimal = imgAnimal;
    }

    @Override
    public String toString() {
        return this.vulgarName +" "+ this.scientificName;
    }
}
