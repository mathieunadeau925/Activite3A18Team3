package com.team3.main;

import com.team3.models.ListPlaces;
import com.team3.models.Localisation;
import com.team3.models.NearbySearch;
import com.team3.util.UtilNearbySearch;
import com.team3.util.UtilPlaceDetails;
import gsonModels.Place;
import gsonModels.Review;
import java.util.ArrayList;

public class AppCtr {

    public static void main(String[] args) {
        ListPlaces listPlaces;
        String latitude = "45.52048";
        String longitude = "-73.5686184";
        int radius = 1500;
        String type = "food";

        Localisation loc = new Localisation(latitude, longitude);
        NearbySearch nearbySearchAttributes = new NearbySearch();
        nearbySearchAttributes.setLocalisation(loc);
        nearbySearchAttributes.setRadius(radius);
        nearbySearchAttributes.setTypePlace(type);
        
        listPlaces = UtilNearbySearch.getNearbyPlacesWithType(nearbySearchAttributes);
        
        for(int i = 0; i < listPlaces.getListPlaces().size(); i++) {
            Place p = listPlaces.getListPlaces().get(i);
            System.out.println(p.getPlace_id());
            ArrayList<Review> listReviews = UtilPlaceDetails.getPlaceDetails(p.getPlace_id());
            p.setListReviews(listReviews);
        }
        
        listPlaces.afficherListe();
        
    }
}
