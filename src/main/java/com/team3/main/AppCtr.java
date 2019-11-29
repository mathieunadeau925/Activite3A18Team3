package com.team3.main;

import com.team3.util.GoogleKey;
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

public class AppCtr {

    public static void main(String[] args) {
       
        long epoch = 1574970764;
        double lat = 45;
        double lon = -73;
        makeCall(lat, lon, epoch, GoogleKey.getGOOGLE_API_KEY());
    }

    private static void makeCall(double lat, double lon, long epoch, String GOOGLE_API_KEY) {
//creer votre client HTTP
        HttpClient client = HttpClientBuilder.create().build();
//creer votre URL de votre service en specifiant type de connexion HTTP/HTTPS , host et chemin de la API
        URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/timezone/json");
        String location = lat + "," + lon;
//Ajouter a votre URL le paramettre localisation en specifiant la cle et la valeur
        builder.addParameter("location", location);
//Ajouter a votre URL le paramettre timestamp en specifiant la cle et la valeur
        builder.addParameter("timestamp", String.valueOf(epoch));
//Ajouter a votre URL le paramettre GOOGLE_API_KEY en specifiant la cle et la valeur
        builder.addParameter("key", GOOGLE_API_KEY);
        try {
//Creer la requete Get a partir de votre URL
            HttpUriRequest request = new HttpGet(builder.build());
//Executer la requete Get a partir de votre URL
            HttpResponse execute = client.execute(request);
//Convertir la reponse a un String
            String response = EntityUtils.toString(execute.getEntity());
//afficher la reponse
            System.out.println(response);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
