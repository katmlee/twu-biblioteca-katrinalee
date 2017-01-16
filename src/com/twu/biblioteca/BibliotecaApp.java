package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();
    private static ArrayList<Movie> movies = new ArrayList<Movie>();
    private ArrayList<User> users = new ArrayList<User>();
    LibraryReader libraryReader = new LibraryReader();


    private boolean isALibraryBook;
    private boolean isALibraryMovie;
    private String userInfo;
    private String welcomeMessage = "Welcome to Biblioteca- your stop for all your library needs!";

    public String welcomeMessage(){
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    public ArrayList<Book>  createBookList(){
        Book b1 = new Book("Head First Java", "Kathy Sierra", 2003, true, "n/a");
        Book b2 = new Book("Test-Driven Development", "Kent Beck", 2003, true, "n/a");
        Book b3 = new Book("Agile Fundamentals", "Someone", 2010, true, "n/a");
        Book b4 = new Book("Ruby Ninjas", "Joel", 1909, false, "n/a");

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        return books;

    }
    public static ArrayList<Movie>  createMovieList(){
        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true, " ");
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false,  "n/a");
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", false, " ");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        return movies;

    }

    public ArrayList<User>  createUserList(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);

        users.add(user);

        return users;

    }


    public void displayBookList(){
        System.out.println(books);
    }

    public void displayMovieList(){
        System.out.println(movies);
    }

    public boolean checkIfLibraryBook(String bookToCheck){
        for (Book book : books){
            if (book.getTitle().equals(bookToCheck)){
                isALibraryBook = true;
            }
        }
        return isALibraryBook;
    }

    public String checkoutBook(String bookToCheckout, String libraryNumber){
        for (Book book : books) {
            if (checkIfLibraryBook(bookToCheckout)) {
                if(book.getCheckedIn()) {
                    book.setCheckedIn(false);
                    book.setCheckedOutBy(libraryNumber);
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
        return bookToCheckout;
    }

    public String returnBook(String bookToReturn){
        for (Book book : books){
            if (checkIfLibraryBook(bookToReturn)) {
                if( !book.getCheckedIn()) {
                    book.setCheckedIn(true);
                    book.setCheckedOutBy("n/a");
                    System.out.println("Thank you for returning the book!");
                } else {
                    System.out.println("This book wasn't checked out!");
                }
                break;
            }
            if(!isALibraryBook) {
                System.out.println("This book is not in our catalog!");
            }
        }
        return bookToReturn;
    }

    public boolean checkIfLibraryMovie(String movieToCheck){
        for (Movie movie : movies){
            if (movie.getTitle().equals(movieToCheck)){
                isALibraryMovie = true;
            }
        }
        return isALibraryMovie;
    }

    public String checkoutMovie(String movieToCheckout, String libraryNumber){
        for (Movie movie : movies){
            if (checkIfLibraryMovie(movieToCheckout)) {
                if( movie.getCheckedIn()) {
                    movie.setCheckedIn(false);
                    movie.setCheckedOutBy(libraryNumber);
                    System.out.println("You've checked out the movie!");
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
        for (Movie movie : movies){
            if (checkIfLibraryMovie(movieToReturn)) {
                if( !movie.getCheckedIn()) {
                    movie.setCheckedIn(true);
                    movie.setCheckedOutBy("n/a");
                    System.out.println("Thank you for returning the movie!");
                } else {
                    System.out.println("This movie wasn't checked out!");
                }
                break;
            }
            if(!isALibraryMovie) {
                System.out.println("This movie is not in our catalog!");
            }
        }
        return movieToReturn;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User createUser(String name, String email, String phone, String libraryNumber, String password, boolean isLoggedIn) {
        User user = new User(name, email, phone, libraryNumber, password, isLoggedIn);
        addUser(user);
        return user;
    }

    public String displayUserInformation(String libraryNumber){
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                userInfo = user.getName() + " " + user.getEmail() + " " + user.getPhone();
                System.out.println(userInfo);
            }
        }
        return userInfo;
    }

    public String login(String libraryNumber, String password){
        createUserList();
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                if (user.getPassword().equals(password)) {
                    user.setIsLoggedIn(true);
                    menu(libraryNumber);
                } else {
                    System.out.println("Password did not match. Try again!");
                }
            } else {
                System.out.println("That is an invalid library number");
            }
        }
        return libraryNumber;

    }

    public void initialLogin() {

        String libraryNumberInput = libraryReader.getReading("What is your library card number? ");
        String passwordInput = libraryReader.getReading("What is your password? ");

        this.login(libraryNumberInput, passwordInput);
    }

    public void menu(String libraryNumber) {
        int selection = Integer.parseInt(libraryReader.getReading("Choose from these options:\n 1 - Display list of books \n 2 - Check out book \n 3 - Return book \n 4 - Display list of movies \n 5 - Check out movie \n 6 - Return movie \n 7 - See User Information \n 8 - Quit \n"));

        switch(selection)
        {
            case 1:
                displayBookList();
                break;
            case 2:
                String bookToCheckOut = libraryReader.getReading("What book would you like to check out? ");
                checkoutBook(bookToCheckOut, libraryNumber);
                break;
            case 3:
                String bookToCheckin = libraryReader.getReading("What book would you like to return? ");
                returnBook(bookToCheckin);
                break;
            case 4:
                displayMovieList();
                break;
            case 5:
                String movieToCheckOut = libraryReader.getReading("What movie would you like to check out? ");
                checkoutMovie(movieToCheckOut, libraryNumber);
                break;
            case 6:
                String movieToCheckin = libraryReader.getReading("What book would you like to return? ");
                returnMovie(movieToCheckin);
                break;

            case 7:
                String libraryNumberToLookUp = libraryReader.getReading("What user would you like to look up? Please end the libary card number. ");
                displayUserInformation(libraryNumberToLookUp);
                break;
            case 8:
                System.out.println("-----------");
                break;
            default:
                System.out.println("Select a valid option!");

        }

    }

    public static void main(String[] args) {
        BibliotecaApp guest = new BibliotecaApp();
//        BibliotecaApp guest = new BibliotecaApp(createBookList(), createMovieList());
        guest.welcomeMessage();
        guest.createBookList();
        guest.createMovieList();
        guest.initialLogin();
    }
}