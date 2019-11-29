package com.team3.main;
import com.team3.util.UtilJsonBuilder;

public class AppCtr {

    public static void main(String[] args) {
        
        System.out.println(UtilJsonBuilder.traiterFichierGson("45.52048", "-73.5686184", 1500, "food"));
        
    }
}
