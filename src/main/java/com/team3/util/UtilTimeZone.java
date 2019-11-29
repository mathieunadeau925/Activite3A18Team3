package com.team3.util;

import com.sun.jna.platform.win32.Sspi;
import com.team3.main.AppCtr;
import com.team3.models.Localisation;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class UtilTimeZone {

    public static void makeCallTimeZone(Localisation loc, Sspi.TimeStamp epoch, String GOOGLE_API_KEY) {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/timezone/json");
        Localisation location = loc;

        //builder.addParameter("location", location); 
        // String location = lat + "," + lon;
        builder.addParameter("timestamp", String.valueOf(epoch));

        builder.addParameter("key", GOOGLE_API_KEY);
        try {

            HttpUriRequest request = new HttpGet(builder.build());
            HttpResponse execute = client.execute(request);
            String response = EntityUtils.toString(execute.getEntity());
            System.out.println(response);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
