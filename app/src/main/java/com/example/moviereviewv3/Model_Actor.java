package com.example.moviereviewv3;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model_Actor implements Serializable {
    private int id;
    private String name;
    private int image;
    private int age;
    private String dateOfBirth;
    private String role;
    private String detail;
    private String movie;

    public Model_Actor() {
        this.name = "";
        this.movie="";
        this.age = 0;
        this.dateOfBirth = "";
        this.role = "";
        this.detail = "";
    }

    public Model_Actor(int image, int age, String dateOfBirth, String name, String role, String movie, String detail) {
        this.image = image;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.role = role;
        this.detail = detail;
        this.movie = movie;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
