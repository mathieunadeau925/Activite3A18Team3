/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.models;

/**
 *
 * @author 1995159
 */
public class PlaceDetails {
    private String place_id;

    public PlaceDetails() {
    }

    public PlaceDetails(String place_id) {
        this.place_id = place_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    @Override
    public String toString() {
        return "PlaceDetails{" + "place_id=" + place_id + '}';
    }
}