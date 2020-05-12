package com.example.petjadesapp.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {
    private double x;
    private double y;
    private String date;

    public Coordinate(){};

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
        result.put("x", x);
        result.put("y", y);
        result.put("date", date);

        return result;
    }
}
