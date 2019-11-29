package com.team3.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team3.util.UtilJsonBuilder;
import net.sf.json.JSONArray;

public class AppCtr {

    public static void main(String[] args) {
        JSONArray liste = UtilJsonBuilder.traiterFichierGson("45.52048", "-73.5686184", 1500, "food");
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.setPrettyPrinting().create();
        String jsonArray = gson.toJson(liste);
        System.out.println(jsonArray);

    }
}
