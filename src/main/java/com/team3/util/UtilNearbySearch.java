package com.team3.util;

import com.team3.main.AppCtr;
import com.team3.models.ListResultsNearbySearch;
import com.team3.models.Localisation;
import com.team3.models.NearbySearch;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class UtilNearbySearch {

    private ListResultsNearbySearch listResults = new ListResultsNearbySearch();

    public ListResultsNearbySearch getNearbyPlaces(NearbySearch nearbySearchAttributes) {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/place/json");
        String location = nearbySearchAttributes.getLocalisation().getLatitude()
                + "," + nearbySearchAttributes.getLocalisation().getLongitude();
        builder.addParameter("location", location);
        builder.addParameter("radius", String.valueOf(nearbySearchAttributes.getRadius()));
        builder.addParameter("key", GoogleKey.getGOOGLE_API_KEY());
        try {
            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String objectString = EntityUtils.toString(execute.getEntity());
            System.out.println(objectString);
            jsonBuilderNearbySearch(objectString);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    
    public JSONArray jsonBuilderNearbySearch(String objectString) {
        return null;
    }
}
