/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.util;

/**
 *
 * @author 1995046
 */
public class GoogleKey {

    private static String GOOGLE_API_KEY = "AIzaSyD7a_uULBq-ZHnWVyx8m52fK7Sa1CCAqko";

    public static String getGOOGLE_API_KEY() {
        return GOOGLE_API_KEY;
    }

    private GoogleKey() {
    }

    public static GoogleKey getInstance() {
        return GoogleKeyHolder.INSTANCE;
    }

    private static class GoogleKeyHolder {

        private static final GoogleKey INSTANCE = new GoogleKey();
    }
}
