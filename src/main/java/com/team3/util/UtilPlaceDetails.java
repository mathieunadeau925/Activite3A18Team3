package com.team3.util;

import com.google.gson.JsonObject;
import com.team3.main.AppCtr;
import com.team3.models.PlaceDetails;
import gsonModels.Review;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class UtilPlaceDetails {
    
    private static ArrayList<Review> listReview ;
    
    public static ArrayList<Review> getPlaceDetails(String placeID){
        
        listReview = new ArrayList<>();
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/place/details/json");
        builder.addParameter("placeid", placeID);
        builder.addParameter("key", GoogleKey.getGOOGLE_API_KEY());
        
        try {

            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String response = EntityUtils.toString(execute.getEntity());
            extractJsonArrayReviews(response);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listReview;
    }

    private static void extractJsonArrayReviews(String response) {
        JSONObject result = JSONObject.fromObject(response);
        result = result.getJSONObject("result");
        JSONArray reviews = result.getJSONArray("reviews");
        for (int i = 0; i < reviews.size(); i++) {
            JSONObject review = reviews.getJSONObject(i);
            Review r = new Review(review.getInt("rating"), review.getString("text"));
            listReview.add(r);
        }
    }
}
