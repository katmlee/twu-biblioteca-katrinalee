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

    public String getDirector(){
        return director;
    }

    public int getYear(){
        return year;
    }

    public boolean getCheckedIn(){
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn){
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString(){
        return "\n Movie title: " + this.getTitle() + " Director: " + this.getDirector() + " Year Published: " + this.getYear()+ "\n";
    }

}
