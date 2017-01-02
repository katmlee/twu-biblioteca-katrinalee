package com.twu.biblioteca;

public class Movie
{
    private String title;
    private int year;
    private String director;
    private String rating;
    private Boolean checkedIn;

    public Movie(String title, int year, String director, String rating, boolean checkedIn){
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedIn = checkedIn;
    }

    public String getTitle(){
        return title;
    }

}
