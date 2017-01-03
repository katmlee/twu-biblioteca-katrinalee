package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private ArrayList<User> users = new ArrayList<User>();

    private boolean isALibraryBook;
    private boolean isALibraryMovie;
    private String userInfo;
    private String welcomeMessage = "Welcome to your Biblioteca- your stop for all your library needs!";

    public String welcomeMessage(){
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    public ArrayList<Book>  createBookList(){
        Book b1 = new Book("Head First Java", "Kathy Sierra", 2003, true);
        Book b2 = new Book("Test-Driven Development", "Kent Beck", 2003, true);
        Book b3 = new Book("Agile Fundamentals", "Someone", 2010, true);
        Book b4 = new Book("Ruby Ninjas", "Joel", 1909, true);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        return books;

    }
    public ArrayList<Movie>  createMovieList(){
        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true);
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false);
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", true);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        return movies;

    }

    public void displayBookList(){
        createBookList();
        System.out.println(books);
    }

    public boolean getIsALibraryBook(){
        return isALibraryBook;
    }

    public String checkoutBook(String bookToCheckout){
        createBookList();
        for (Book book : books) {
            if (book.getTitle().contains(bookToCheckout)) {
                isALibraryBook = true;
                if(book.getCheckedIn()) {
                    book.setCheckedIn(false);
                    System.out.println("Thanks for checking out " + bookToCheckout + ". Enjoy the book! ");
                } else {
                    System.out.println("Sorry, this book is currently checked out.");
                }
                break;
            }
        }
        if(!isALibraryBook) {
            System.out.println("Sorry, that book is not in our library catalog. Please try another.");
        }
        System.out.println(isALibraryBook);
        return bookToCheckout;
    }

    public String returnBook(String bookToCheckin){
        createBookList();
        for (Book book : books) {
            if (book.getTitle().equals(bookToCheckin)) {
                isALibraryBook = true;
                book.setCheckedIn(true);
                System.out.println("Thank you for returning the book!");
            }
        }
        if(!isALibraryBook) {
            System.out.println("Sorry, that book is not in our library catalog.");
        }
        return bookToCheckin;
    }

    public boolean checkIfLibraryMovie(String movieToCheck){
        createMovieList();
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieToCheck)){
                isALibraryMovie = true;
            }
        }
        return isALibraryMovie;
    }

    public String checkoutMovie(String movieToCheckout){
        createMovieList();
        for (Movie movie : movies){
            if (checkIfLibraryMovie(movieToCheckout)) {
                if( movie.getCheckedIn()) {
                    movie.setCheckedIn(false);
                    System.out.println(movie.getCheckedIn() + "You've checked out the movie!");
                } else {
                    System.out.println("This movie is currently checked out!");
                }
                break;
            }
            if(!isALibraryMovie) {
                System.out.println("This movie is not in our catalog!");
            }
        }
        return movieToCheckout;
    }

    public String returnMovie(String movieToReturn){
        createMovieList();
        for (Movie movie : movies){
            if (checkIfLibraryMovie(movieToReturn)) {
                if( !movie.getCheckedIn()) {
                    movie.setCheckedIn(true);
                    System.out.println("Thank you for returning the movie!");
                } else {
                    System.out.println("This movie wasn't checkedout!");
                }
                break;
            }
            if(!isALibraryMovie) {
                System.out.println("This movie is not in our catalog!");
            }
        }
        return movieToReturn;
    }

    public User retrieveUser(int libraryNumber){
        return users.get(libraryNumber);
    }

    public String displayUserInformation(int libaryNumber){
        User user = retrieveUser(libaryNumber);
        userInfo = user.getName() + " " + user.getEmail() + " " + user.getPhone();
        System.out.println(userInfo);
        return userInfo;
    }

    public void menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("1 - Display list of books");
        System.out.println("2 - Check out book");
        System.out.println("3 - Return book");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        switch(selection)
        {
            case 1:
                displayBookList();
                break;
            case 2:
                System.out.println("What book would you like to check out?");
                Scanner bookName = new Scanner(System.in);
                String bookToCheckOut = bookName.nextLine();
                checkoutBook(bookToCheckOut);
                break;
            case 3:
                System.out.println("What book would you like to return?");
                Scanner bookReturn = new Scanner(System.in);
                String bookToCheckin = bookReturn.nextLine();
                returnBook(bookToCheckin);
                break;
            case 4:
                System.out.println("-----------");
                break;
            default:
                System.out.println("Select a valid option!");

        }

    }

    public static void main(String[] args) {
        BibliotecaApp guest = new BibliotecaApp();
        guest.welcomeMessage();
        guest.menu();
    }
}