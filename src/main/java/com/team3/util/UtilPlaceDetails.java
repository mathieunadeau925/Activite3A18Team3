package com.team3.util;

import com.google.gson.JsonObject;
import com.team3.main.AppCtr;
import com.team3.models.PlaceDetails;
import gsonModels.Review;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class UtilPlaceDetails {
    
    
    
    public static ArrayList<PlaceDetails> getPlaceDetails(String placeID){
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/api/place/details/json");
        ArrayList<PlaceDetails> listPlaceDetails = new ArrayList<>();

        builder.addParameter("place_id", placeID);
        builder.addParameter("key", GoogleKey.getGOOGLE_API_KEY());
        
        try {

            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String response = EntityUtils.toString(execute.getEntity());
            listPlaceDetails=extractJsonArrayReviews(response);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listPlaceDetails;
    }

    private static ArrayList<PlaceDetails> extractJsonArrayReviews(String response) {
        //JSONObject reviews = JsonObject.fromObject(response);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
