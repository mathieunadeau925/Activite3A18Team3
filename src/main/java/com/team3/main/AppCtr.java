package com.team3.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.models.ListPlaces;
import com.team3.models.Localisation;
import com.team3.models.NearbySearch;
import com.team3.util.UtilNearbySearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.util.UtilPlaceDetails;
import gsonModels.Place;
import gsonModels.Review;
import gsonModels.UtilGsonConverter;
import java.util.ArrayList;

public class AppCtr {

    public static void main(String[] args) {
        
        System.out.println(UtilGsonConverter.traiterFichierGson("45.52048", "-73.5686184", 1500, "food"));
        
    }
}
