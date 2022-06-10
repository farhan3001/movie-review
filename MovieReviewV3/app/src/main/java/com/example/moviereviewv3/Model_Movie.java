package com.example.moviereviewv3;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model_Movie implements Serializable {
    private int image;
    private String name;
    private String year;
    private String duration;
    private String genre;
    private String description;
    private String cast;
    private String director;
    private String writer;
    private float rating;
    private Model_Review review;
    private String trailer;

    public Model_Movie(){

    }

    public Model_Movie(int image, String name, String year, String duration, String genre, String description, String cast, String director, String writer, float rating, Model_Review review, String trailer) {
        this.image = image;
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.description = description;
        this.cast = cast;
        this.director = director;
        this.writer = writer;
        this.rating = rating;
        this.review = review;
        this.trailer = trailer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Model_Review getReview() {
        return review;
    }

    public void setReview(Model_Review review) {
        this.review = review;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

}
