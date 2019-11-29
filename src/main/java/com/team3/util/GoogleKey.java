package com.team3.util;

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
