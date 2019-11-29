package com.team3.models;

public class NearbySearch {
    private Localisation localisation;
    private double radius;
    private String placeId;

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public NearbySearch() {
    }

    public NearbySearch(Localisation localisation, double radius, String placeId) {
        this.localisation = localisation;
        this.radius = radius;
        this.placeId = placeId;
    }
    
    
}
