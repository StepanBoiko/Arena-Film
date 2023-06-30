package com.company.ArenaFilm.models;
import javax.persistence.*;
import java.sql.DataTruncation;

@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String year;
    private String genre;
    private String country;
    private String company;
    private String rating;
    private String duration;
    private String ageLimit;

    private User author;


    public Films(String name, String year, String genre, String country, String company, String rating, String duration, String ageLimit) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.country = country;
        this.company = company;
        this.rating = rating;
        this.duration = duration;
        this.ageLimit = ageLimit;
    }

    public Films(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
