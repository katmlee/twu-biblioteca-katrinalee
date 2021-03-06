package com.twu.biblioteca;

public class Book implements LibraryItem {

    private String title;
    private String author;
    private int year;
    private boolean checkedIn;
    private String checkedOutBy;

    public Book(String title, String author, int year, boolean checkedIn, String checkedOutBy) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedIn = checkedIn;
        this.checkedOutBy = checkedOutBy;
    }

    public void setCheckedIn(boolean checkedIn){
        this.checkedIn = checkedIn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
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

    @Override
    public String toString(){
        return "\n Book title: " + this.getTitle() + " Author: " + this.getAuthor() + " Year Published: " + this.getYear()+ this.getCheckedIn()+ "\n";
    }
}
