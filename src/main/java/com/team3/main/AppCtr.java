package com.team3.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.util.UtilJsonBuilder;
import net.sf.json.JSONArray;

public class AppCtr {

    public static void main(String[] args) {
        //test du service, qui demanderais une latitude, longitude, rayon et type
        JSONArray liste = UtilJsonBuilder.traiterFichierGson("45.52048", "-73.5686184", 1500, "food");
        
        //J'affiche mon JSONArray
        UtilJsonBuilder.afficherMonJSONArray(liste);
    }
}
