package com.example.moviereviewv3;

public class Model_Review {
    private float rating;
    private String title;
    private String description;
    private String reviewer_name;
    private String movie_name;


    public Model_Review(float rating, String title, String description, String reviewer_name, String movie_name) {
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.reviewer_name=reviewer_name;
        this.movie_name=movie_name;
    }

    public Model_Review() {
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReviewer_name() {
        return reviewer_name;
    }

    public void setReviewer_name(String reviewer_name) {
        this.reviewer_name = reviewer_name;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
}
