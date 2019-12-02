package com.team3.models;

public class NearbySearch {

    private Localisation localisation;
    private double radius;
    private String typePlace;

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

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    public NearbySearch() {
    }

    public NearbySearch(Localisation localisation, double radius, String typePlace) {
        this.localisation = localisation;
        this.radius = radius;
        this.typePlace = typePlace;
    }
}
