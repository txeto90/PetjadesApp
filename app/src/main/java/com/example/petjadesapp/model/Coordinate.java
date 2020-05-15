package com.example.petjadesapp.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {
    private double lon;
    private double lat;
    private String date;
    //privat eString user
    //private boolean visible;
    //private String animal;

    public Coordinate(){};

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("x", lon);
        result.put("y", lat);
        result.put("date", date);

        return result;
    }
}
