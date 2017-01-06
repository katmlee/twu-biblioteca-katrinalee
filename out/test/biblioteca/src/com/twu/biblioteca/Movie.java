package com.twu.biblioteca;

public class Movie
{
    private String title;
    private int year;
    private String director;
    private String rating;
    private Boolean checkedIn;
    private String checkedOutBy;

    public Movie(String title, int year, String director, String rating, boolean checkedIn, String checkedOutBy){
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedIn = checkedIn;
        this.checkedOutBy = checkedOutBy;
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

    public String getCheckedOutBy(){
        return checkedOutBy;
    }

    public void setCheckedOutBy(String checkedOutBy){
        this.checkedOutBy = checkedOutBy;
    }

    public void setCheckedIn(boolean checkedIn){
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString(){
        return "\n Movie title: " + this.getTitle() + " Director: " + this.getDirector() + " Year Published: " + this.getYear()+ "\n";
    }

}
