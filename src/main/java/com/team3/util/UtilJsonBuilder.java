package com.team3.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.models.Review;
import com.team3.models.Place;
import com.team3.models.ListPlaces;
import com.team3.models.Localisation;
import com.team3.models.NearbySearch;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UtilJsonBuilder {

    public static JSONArray traiterFichierGson(String latitude, String longitude, int radius, String type) {
        ListPlaces listPlaces;

        Localisation loc = new Localisation(latitude, longitude);
        NearbySearch nearbySearchAttributes = new NearbySearch();
        nearbySearchAttributes.setLocalisation(loc);
        nearbySearchAttributes.setRadius(radius);
        nearbySearchAttributes.setTypePlace(type);

        listPlaces = UtilNearbySearch.getNearbyPlacesWithType(nearbySearchAttributes);

        for (int i = 0; i < listPlaces.getListPlaces().size(); i++) {
            Place p = listPlaces.getListPlaces().get(i);
            ArrayList<Review> listReviews = UtilPlaceDetails.getPlaceDetails(p.getPlace_id());
            p.setListReviews(listReviews);
        }
        //JSONArray result = creerJsonFile(listPlaces);
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        String listPlacesObjet = gson.toJson(listPlaces);
        JSONObject obj = JSONObject.fromObject(listPlacesObjet);
        JSONArray listPlacesArray = obj.getJSONArray("listPlaces");
        
        return listPlacesArray;
    }

    public static JSONArray creerJsonFile(ListPlaces listPlaces) {
        JSONArray results = new JSONArray();
        for (Place p : listPlaces.getListPlaces()) {
            JSONObject res = new JSONObject();
            res.accumulate("place_id", p.getPlace_id());
            res.accumulate("name", p.getName());
            res.accumulate("vicinity", p.getVicinity());
            JSONArray reviews = new JSONArray();
            if (p.getListReviews().size() > 0) {
                for (Review r : p.getListReviews()) {
                    JSONObject reviewObject = new JSONObject();
                    reviewObject.accumulate("rating", r.getRating());
                    reviewObject.accumulate("text", r.getText());
                    reviews.add(r);
                }
            }
            res.accumulate("reviews", reviews);
            results.add(res);
        }
        return results;
    }
    
    
    public static void afficherMonJSONArray(JSONArray jsArray) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.setPrettyPrinting().create();
        String jsonArray = gson.toJson(jsArray);
        System.out.println(jsonArray);
    }
    
}
