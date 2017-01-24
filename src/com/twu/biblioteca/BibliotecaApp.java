package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class BibliotecaApp {

    private final ArrayList<LibraryItem> libraryItems;

    public BibliotecaApp(ArrayList<Book> books, ArrayList<Movie> movies, LibraryReader libraryReader){
        this.books = books;
        this.movies = movies;
        this.libraryItems = new ArrayList<LibraryItem>();
        this.libraryItems.addAll(books);
        this.libraryItems.addAll(movies);
        this.libraryReader = libraryReader;
    }

    public LibraryReader getLibraryReader() {
        return libraryReader;
    }

    private static LibraryReader libraryReader;

    private static ArrayList<Book> books = new ArrayList<Book>();
    private static ArrayList<Movie> movies = new ArrayList<Movie>();
    private static ArrayList<User> users = new ArrayList<User>();


    private boolean isALibraryItem;
    private boolean isALibraryMovie;
    private String userInfo;
    private String welcomeMessage = "Welcome to Biblioteca- your stop for all your library needs!";

    public String welcomeMessage(){
        System.out.println(welcomeMessage);
        return welcomeMessage;
    }

    public static ArrayList<Book>  createBookList(){
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
        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true, "n/a");
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false,  "n/a");
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", false, "n/a");
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

    public boolean checkIfLibraryItem(String itemToCheck){
        for (LibraryItem item : libraryItems){
            if (item.getTitle().equals(itemToCheck)){
                isALibraryItem = true;
            }
        }
        return isALibraryItem;
    }

    public String checkoutItem(String itemToCheckout, String libraryNumber, ItemType itemType){
        for (LibraryItem item : libraryItems) {
            if (checkIfLibraryItem(itemToCheckout)) {
                if(item.getCheckedIn()) {
                    item.setCheckedIn(false);
                    item.setCheckedOutBy(libraryNumber);
                    System.out.println("Thanks for checking out " + itemToCheckout + ".");
                } else {
                    System.out.println("Sorry, this library item is currently checked out.");
                }
                break;
            }
        }
        if(!isALibraryItem) {
            System.out.println("Sorry, that library item is not in our library catalog. Please try another.");
        }
        return itemToCheckout;
    }

    public String returnItem(String itemToReturn, ItemType itemType){
        for (LibraryItem item : libraryItems) {
            if (checkIfLibraryItem(itemToReturn)) {
                if( !item.getCheckedIn()) {
                    item.setCheckedIn(true);
                    item.setCheckedOutBy("n/a");
                    System.out.println("Thank you for returning the library item!");
                } else {
                    System.out.println("This library item wasn't checked out!");
                }
                break;
            }
            if(!isALibraryItem) {
                System.out.println("This library item is not in our catalog!");
            }
        }
        return itemToReturn;
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
                checkoutItem(bookToCheckOut, libraryNumber, ItemType.BOOK);
                break;
            case 3:
                String bookToCheckin = libraryReader.getReading("What book would you like to return? ");
                returnItem(bookToCheckin, ItemType.MOVIE);
                break;
            case 4:
                displayMovieList();
                break;
            case 5:
                String movieToCheckOut = libraryReader.getReading("What movie would you like to check out? ");
                checkoutItem(movieToCheckOut, libraryNumber, ItemType.MOVIE);
                break;
            case 6:
                String movieToCheckin = libraryReader.getReading("What book would you like to return? ");
                returnItem(movieToCheckin, ItemType.MOVIE);
                break;

            case 7:
                String libraryNumberToLookUp = libraryReader.getReading("What user would you like to look up? Please enter the libary card number. ");
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
        LibraryReader libraryReader = new LibraryReader(System.in);
        BibliotecaApp guest = new BibliotecaApp(createBookList(), createMovieList(), libraryReader);
        guest.welcomeMessage();
        guest.initialLogin();
    }
}