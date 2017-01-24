package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;



import java.util.*;

public class BibliotecaTest {
    private BibliotecaApp library;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;
//    private LibraryReader libraryReader;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        LibraryReader libraryReader = new LibraryReader(System.in);
        library = new BibliotecaApp(library.createBookList(), library.createMovieList(), libraryReader);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        assertEquals("Welcome to Biblioteca- your stop for all your library needs!", library.welcomeMessage());
    }

    @Test
    public void shouldCreateNewListOfBooks() {
        Book book1 = new Book("Help Me", "Gary Cook", 1990, true, "n/a");
        Book book2 = new Book("Develop", "Katurtle", 1940, true, "n/a");
        books.add(book1);
        books.add(book2);
        assertEquals(books.size(), 2);
    }

    @Test
    public void shouldCreateNewBook() {
        Book book = new Book("Help Me", "Gary Cook", 1990, true, "n/a");

        assertEquals(book.getTitle(), "Help Me");
    }

    @Test
    public void shouldAddBookToBookList() {
        Book book = new Book("Help Me", "Gary Cook", 1990, true, "n/a");
        books.add(book);
        assertEquals(books.size(), 1);
    }

    @Test
    public void shouldCheckTheMenuPrintsOutAListOfOptions() {

    }

    @Test
    public void shouldCheckIfBookExistsInSystem() {

        assertFalse(library.checkIfLibraryItem("Java Masters"));

        assertTrue(library.checkIfLibraryItem("Head First Java"));
    }

    @Test
    public void shouldConfirmBookIsCheckedInBeforeItGetsCheckedout() {

        Book book = new Book("Head", "Kathy Sierra", 2003, true, "n/a");
        books.add(book);
        LibraryReader libraryReader = null;
        library = new BibliotecaApp(books, library.createMovieList(), libraryReader);

        System.out.println(books.get(0).getCheckedIn());

        library.checkoutItem("Head", "193-2016", ItemType.BOOK);

        assertFalse(books.get(0).getCheckedIn());

    }

    @Test
    public void shouldSetBookToCheckedOutAndReturnBook() {
        Book book = new Book("Head", "Kathy Sierra", 2003, true, "n/a");
        books.add(book);
        LibraryReader libraryReader = null;
        library = new BibliotecaApp(books, library.createMovieList(), libraryReader);

        library.checkoutItem("Head", "123-2016", ItemType.BOOK);

        assertFalse(books.get(0).getCheckedIn());
    }

    @Test
    public void shouldSetBookToCheckedinAndReturnBook() {
        Book book = new Book("Head", "Kathy Sierra", 2003, true, "n/a");
        books.add(book);
        LibraryReader libraryReader = null;
        library = new BibliotecaApp(books, library.createMovieList(), libraryReader);

        library.checkoutItem("Head", "123-2016", ItemType.BOOK);
        assertFalse(books.get(0).getCheckedIn());

        library.returnItem("Head", ItemType.BOOK);

        assertTrue(books.get(0).getCheckedIn());

    }

    @Test
    public void shouldCreateNewMovie() {
        Movie movie = new Movie("Barry", 2016, "Jon Siegal", "8", true, "n/a");

        assertEquals(movie.getTitle(), "Barry");

    }

    @Test
    public void shouldPrintOutListOfMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true, "n/a");
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false, "n/a");
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", true, "n/a");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);


        assertEquals(movies.size(), 3);

    }

    @Test
    public void shouldCheckIfMovieIsInMovieList() {
        assertFalse(library.checkIfLibraryItem("When Harry Met Sally"));
        assertTrue(library.checkIfLibraryItem("Barry"));
    }

    @Test
    public void shouldCheckOutMovieAndReturnMovieAndSetCheckedInToFalse() {
        Movie movie = new Movie ("Barry", 2016, "Jon Siegal", "8", true, "n/a");
        movies.add(movie);
        LibraryReader libraryReader = null;
        library = new BibliotecaApp(books, movies, libraryReader);

        library.checkoutItem("Barry", "123-2016", ItemType.MOVIE);

        assertEquals(false, movies.get(0).getCheckedIn());
    }

    @Test
    public void shouldCheckInMovieAndReturnMovieAndSetCheckedInToTrue(){
        Movie movie = new Movie ("Frozen", 2016, "Jon Siegal", "8", false, "n/a");
        movies.add(movie);
        LibraryReader libraryReader = null;
        library = new BibliotecaApp(books, movies, libraryReader);

        library.returnItem("Frozen", ItemType.MOVIE);

        assertTrue(movies.get(0).getCheckedIn());
        assertEquals(movies.get(0).getTitle(), "Frozen");

    }

    @Test
    public void shouldCreateANewUser(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
        assertEquals(user.getName(), "Katrina");

    }

//    @Test
//    public void shouldLoginTheUser(){
//        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
//        ArrayList<User> users = library.createUserList();
//        LibraryReader libraryReader;
//        String data = "8";
//        InputStream input = System.in;
//        try {
//            System.setIn(new ByteArrayInputStream(data.getBytes()));
//            libraryReader = new LibraryReader(System.in);
//            System.out.println(data);
//        } finally {
//            System.setIn(input);
//        }
//
//        library = new BibliotecaApp(books, movies, libraryReader);
//
//        library.login(users.get(0).getLibraryNumber(), users.get(0).getPassword());
//
//        assertTrue(users.get(0).getIsLoggedIn());
//
//    }

    @Test
    public void shouldDisplayUserInformation(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
        ArrayList<User> users = library.createUserList();

        assertEquals(library.displayUserInformation(users.get(0).getLibraryNumber()), "Katrina katrinamarielee@gmail.com 0451289109");
;
    }

}
