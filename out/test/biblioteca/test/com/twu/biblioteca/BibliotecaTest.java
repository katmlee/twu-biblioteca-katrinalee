package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;

import java.util.*;

public class BibliotecaTest {
    private BibliotecaApp library;

    @Before
    public void setUp() {
        library = new BibliotecaApp();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        assertEquals(library.welcomeMessage(), "Welcome to your Biblioteca- your stop for all your library needs!");
    }

    @Test
    public void shouldCreateNewListOfBooks() {
        List<Book> bookList = library.createBookList();

        assertEquals(bookList.size(), 4);
    }

    @Test
    public void shouldCreateNewBook() {
        Book book = new Book("Help Me", "Gary Cook", 1990, true);

        assertEquals(book.getTitle(), "Help Me");
    }

    @Test
    public void shouldCheckTheMenuPrintsOutAListOfOptions() {

    }

    @Test
    public void shouldPrintOutAListOfBooks() {

    }

    @Test
    public void shouldCheckIfBookExistsInSystem() {
        List<Book> bookList = library.createBookList();

        library.checkoutBook("Java Masters");

        assertFalse(library.getIsALibraryBook());

        library.checkoutBook("Head First Java");

        assertTrue(library.getIsALibraryBook());
    }

    @Test
    public void shouldConfirmBookIsCheckedInBeforeItGetsCheckedout() {
        List<Book> bookList = library.createBookList();

        assertTrue(bookList.get(0).getCheckedIn());

        library.checkoutBook("Head First Java");

        assertFalse(bookList.get(0).getCheckedIn());

    }

    @Test
    public void shouldSetBookToCheckedOutAndReturnBook() {
        List<Book> bookList = library.createBookList();

        library.checkoutBook("Head First Java");

        assertFalse(bookList.get(0).getCheckedIn());
    }

    @Test
    public void shouldSetBookToCheckedinAndReturnBook() {
        List<Book> bookList = library.createBookList();

        library.returnBook("Head First Java");

        assertTrue(bookList.get(0).getCheckedIn());

    }

    @Test
    public void shouldCreateNewMovie() {
        Movie movie = new Movie("Barry", 2016, "Jon Siegal", "8", true);

        assertEquals(movie.getTitle(), "Barry");

    }

    @Test
    public void shouldPrintOutListOfMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true);
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false);
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", true);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);


        assertEquals(movies.size(), 3);

    }

    @Test
    public void shouldCheckIfMovieIsInMovieList() {
        assertFalse(library.checkIfLibraryMovie("When Harry Met Sally"));
        assertTrue(library.checkIfLibraryMovie("Barry"));
    }

    @Test
    public void shouldCheckIfMovieIsCheckedIn() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("Barry", 2016, "Jon Siegal", "8", true);
        Movie movie2 = new Movie("Frozen", 2013, "Disney", "10", false);
        Movie movie3 = new Movie("The Little Mermaid", 1989, "Harold Star", "7", true);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        assertTrue(movies.get(0).getCheckedIn());
        assertFalse(movies.get(1).getCheckedIn());
    }

    @Test
    public void shouldCheckOutMovieAndReturnMovieAndSetCheckedInToFalse() {
        ArrayList<Movie> movies = library.createMovieList();

        library.checkoutMovie("Barry");

        assertEquals(false, movies.get(0).getCheckedIn());
    }

    @Test
    public void shouldCheckInMovieAndReturnMovieAndSetCheckedInToTrue(){
        ArrayList<Movie> movies = library.createMovieList();

        library.returnMovie("The Little Mermaid");

        assertTrue(movies.get(2).getCheckedIn());
        assertEquals(movies.get(2).getTitle(), "The Little Mermaid");

    }

    @Test
    public void shouldCreateANewUser(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
        assertEquals(user.getName(), "Katrina");

    }

    @Test
    public void shouldLoginTheUser(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
        ArrayList<User> users = library.createUserList();

        library.login(users.get(0).getLibraryNumber(), users.get(0).getPassword());

        assertTrue(users.get(0).getIsLoggedIn());

    }

    @Test
    public void shouldDisplayUserInformation(){
        User user = new User("Katrina", "katrinamarielee@gmail.com", "0451289109", "123-2016", "Thoughtworks2016", false);
        ArrayList<User> users = library.createUserList();

        assertEquals(library.displayUserInformation(users.get(0).getLibraryNumber()), "Katrina katrinamarielee@gmail.com 0451289109");
;
    }

}
