package com.team3.main;


import com.team3.util.UtilPlaceDetails;
import gsonModels.Review;
import java.util.ArrayList;


public class AppCtr {

    public static void main(String[] args) {
       String placeID = "ChIJm9yJF0wayUwRO2PxDSXpH0Q";
       ArrayList<Review> l = UtilPlaceDetails.getPlaceDetails(placeID);
        for (Review review : l) {
            System.out.println(review);
        }
    }
}
