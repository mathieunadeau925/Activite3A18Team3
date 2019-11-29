package com.team3.util;

import com.team3.models.Place;
import com.team3.main.AppCtr;
import com.team3.models.ListPlaces;
import com.team3.models.NearbySearch;
import java.io.IOException;
import java.net.URISyntaxException;
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

public class UtilNearbySearch {

    private static ListPlaces listResults = new ListPlaces();

    public static ListPlaces getNearbyPlaces(NearbySearch nearbySearchAttributes) {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps."
                + "googleapis.com").setPath("/maps/api/place/nearbysearch/json");
        String location = nearbySearchAttributes.getLocalisation().getLatitude()
                + "," + nearbySearchAttributes.getLocalisation().getLongitude();
        builder.addParameter("location", location);
        builder.addParameter("radius", String.valueOf(nearbySearchAttributes.getRadius()));
        builder.addParameter("key", GoogleKey.getGOOGLE_API_KEY());
        try {
            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String objectString = EntityUtils.toString(execute.getEntity());
            jsonBuilderNearbySearch(objectString);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    
    public static ListPlaces getNearbyPlacesWithType(NearbySearch nearbySearchAttributes) {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps."
                + "googleapis.com").setPath("/maps/api/place/nearbysearch/json");
        String location = nearbySearchAttributes.getLocalisation().getLatitude()
                + "," + nearbySearchAttributes.getLocalisation().getLongitude();
        builder.addParameter("location", location);
        builder.addParameter("radius", String.valueOf(nearbySearchAttributes.getRadius()));
        builder.addParameter("type", nearbySearchAttributes.getTypePlace());
        builder.addParameter("key", GoogleKey.getGOOGLE_API_KEY());
        try {
            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String objectString = EntityUtils.toString(execute.getEntity());
            jsonBuilderNearbySearch(objectString);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    
    public static void jsonBuilderNearbySearch(String objectString) {
        JSONObject resultsSearch = JSONObject.fromObject(objectString);
        JSONArray arrayResults = resultsSearch.getJSONArray("results");
        JSONObject placeObject = new JSONObject();
        
        for (int i = 0; i < arrayResults.size(); i++) {
            placeObject = arrayResults.getJSONObject(i);
            String place_id = placeObject.getString("place_id");
            String name = placeObject.getString("name");
            String vicinity = placeObject.getString("vicinity");
            Place place = new Place(place_id,name,vicinity,null);
            
            listResults.addTolList(place);
        }
    }
}
