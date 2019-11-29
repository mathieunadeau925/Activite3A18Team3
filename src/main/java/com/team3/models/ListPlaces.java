package com.team3.models;

import gsonModels.Place;
import gsonModels.Review;
import java.util.ArrayList;

public class ListPlaces {
   private ArrayList<Place> listPlaces = 
           new ArrayList<>();
   
   public void addTolList(Place place) {
       listPlaces.add(place);
   }
   
   public void clearList() {
       listPlaces.clear();
   }
   
   public Place findInList(String place_id) {
       for (Place p : listPlaces) {
           if (p.getPlace_id().equals(place_id)) {
               return p;
           }
       }
       return null;
   }

    public void printList() {
        for(Place p : listPlaces) {
            System.out.println(p.toString());
        }
    }
    
    public ArrayList<Place> getListPlaces() {
        return listPlaces;
    }
    
    public void afficherListe() {
        for (Place p : listPlaces) {
            System.out.print(p.getPlace_id() + ", ");
            System.out.print(p.getName()+ ", ");
            System.out.print(p.getVicinity()+ ", ");
            for (Review r : p.getListReviews()) {
                System.out.print(r.getRating() + ", " + r.getText() );
            }
        }
    }
}
