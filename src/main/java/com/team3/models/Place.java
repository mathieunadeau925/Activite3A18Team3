package com.team3.models;

import java.util.ArrayList;

public class Place {
    private String place_id;
    private String name;
    private String vicinity;
    private ArrayList<Review> listReviews;

    public Place() {
    }

    public Place(String place_id, String name, String vicinity, ArrayList<Review> listReviews) {
        this.place_id = place_id;
        this.name = name;
        this.vicinity = vicinity;
        this.listReviews = listReviews;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public ArrayList<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(ArrayList<Review> listReviews) {
        this.listReviews = listReviews;
    }

    @Override
    public String toString() {
        return "Place{" + "place_id=" + place_id + ", name=" + name + ", vicinity=" + vicinity;
    }
    
    
}
