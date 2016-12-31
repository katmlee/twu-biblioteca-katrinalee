package com.twu.biblioteca;

public class Movie
{
    private String title;
    private int year;
    private String director;
    private String rating;

    public Movie(String title, int year, String director, String rating){
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

}
