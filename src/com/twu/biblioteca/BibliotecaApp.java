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
        Book b1 = new Book("Head First Java", "Kathy Sierra", 2003, true, "n/a");
        Book b2 = new Book("Test-Driven Development", "Kent Beck", 2003, true, "n/a");
        Book b3 = new Book("Agile Fundamentals", "Someone", 2010, true, "n/a");
        Book b4 = new Book("Ruby Ninjas", "Joel", 1909, true, "n/a");

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        return books;

    }
    public ArrayList<Movie>  createMovieList(){
        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true, " ");
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false, " ");
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", true, " ");
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
        createBookList();
        System.out.println(books);
    }

    public boolean getIsALibraryBook(){
        return isALibraryBook;
    }

    public String checkoutBook(String bookToCheckout, String libraryNumber){
        createBookList();
        for (Book book : books) {
            if (book.getTitle().contains(bookToCheckout)) {
                isALibraryBook = true;
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

    public String checkoutMovie(String movieToCheckout, String libraryNumber){
        createMovieList();
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
        String libraryNumberInput;
        String passwordInput;
        Scanner input = new Scanner(System.in);

        System.out.println("What is your library card number?");
        libraryNumberInput = input.nextLine();

        Scanner input2 = new Scanner(System.in);

        System.out.println("What is your password?");
        passwordInput = input2.nextLine();

        this.login(libraryNumberInput, passwordInput);
    }

    public void menu(String libraryNumber) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these options:");
        System.out.println("1 - Display list of books");
        System.out.println("2 - Check out book");
        System.out.println("3 - Return book");
        System.out.println("4 - Check out movie");
        System.out.println("5 - Return movie");
        System.out.println("6 - See User Information");
        System.out.println("7 - Quit");

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
                checkoutBook(bookToCheckOut, libraryNumber);
                break;
            case 3:
                System.out.println("What book would you like to return?");
                Scanner bookReturn = new Scanner(System.in);
                String bookToCheckin = bookReturn.nextLine();
                returnBook(bookToCheckin);
                break;
            case 4:
                System.out.println("What movie would you like to check out?");
                Scanner movieName = new Scanner(System.in);
                String movieToCheckOut = movieName.nextLine();
                checkoutMovie(movieToCheckOut, libraryNumber);
                break;
            case 5:
                System.out.println("What book would you like to return?");
                Scanner movieReturn = new Scanner(System.in);
                String movieToCheckin = movieReturn.nextLine();
                returnMovie(movieToCheckin);
                break;

            case 6:
                System.out.println("What user would you like to look up? Please end the libary card number.");
                Scanner libraryNumberLookUp = new Scanner(System.in);
                String libraryNumberToLookUp = libraryNumberLookUp.nextLine();
                displayUserInformation(libraryNumberToLookUp);
                break;
            case 7:
                System.out.println("-----------");
                break;
            default:
                System.out.println("Select a valid option!");

        }

    }

    public static void main(String[] args) {
        BibliotecaApp guest = new BibliotecaApp();
        guest.welcomeMessage();
        guest.initialLogin();
    }
}