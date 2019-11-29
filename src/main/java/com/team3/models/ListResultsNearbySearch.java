package com.team3.models;

import gsonModels.Place;
import java.util.ArrayList;

public class ListResultsNearbySearch {
   private ArrayList<Place> listResultsNearbySearch = 
           new ArrayList<>();
   
   public void addTolList(Place place) {
       listResultsNearbySearch.add(place);
   }
   
   public void clearList() {
       listResultsNearbySearch.clear();
   }
   
   public Place findInList(String place_id) {
       for (Place p : listResultsNearbySearch) {
           if (p.getPlace_id().equals(place_id)) {
               return p;
           }
       }
       return null;
   }
}
