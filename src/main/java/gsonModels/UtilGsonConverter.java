package gsonModels;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.models.ListPlaces;
import com.team3.util.UtilPlaceDetails;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;

public class UtilGsonConverter {

    public static JSONArray traiterFichierGson(ListPlaces listPlace) {
        JSONArray isValide = null;

        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.setPrettyPrinting().create();

        String placeID = "ChIJm9yJF0wayUwRO2PxDSXpH0Q";
        ArrayList<Review> l = UtilPlaceDetails.getPlaceDetails(placeID);
//        for (Review review : l) {
//            System.out.println(review);
//        }

        String jsonArrayReviews = gson.toJson(l);

        System.out.println(jsonArrayReviews.toString());

        return isValide;
    }

    public static Place creerGsonSortie() {
        Place place = new Place();
        return place;
    }

}
