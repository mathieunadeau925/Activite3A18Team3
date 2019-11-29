package com.team3.models;


public class Review {
    private int rating;
    private String text;

    public Review() {
    }

    public Review(int rating, String text) {
        this.rating = rating;
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Review{" + "rating=" + rating + ", text=" + text + '}';
    }
    
    
}
