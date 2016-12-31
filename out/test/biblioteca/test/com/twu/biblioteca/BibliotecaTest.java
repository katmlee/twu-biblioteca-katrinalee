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
        assertEquals( library.welcomeMessage(), "Welcome to your Biblioteca- your stop for all your library needs!");
    }

    @Test
    public void shouldCreateNewListOfBooks() {
        List<Book> bookList = library.createBookList();
        assertEquals(bookList.size(), 4);
    }

    @Test
    public void shouldCreateNewBook(){
        Book book = new Book("Help Me", "Gary Cook",1990, true);
        assertEquals(book.getTitle(), "Help Me");
    }

    @Test
    public void shouldCreateNewMovie(){
        Movie movie = new Movie("Barry", 2016, "Jon Siegal", "8");
        assertEquals(movie.getTitle(), "Barry");

    }


    @Test
    public void shouldCheckTheMenuPrintsOutAListOfOptions(){

    }

    @Test
    public void shouldPrintOutAListOfBooks(){

    }

    @Test
    public void shouldSetBookToCheckedOutAndReturnBook() {
        List<Book> bookList = library.createBookList();
        library.checkoutBook("Head First Java");
        assertEquals(false, bookList.get(0).getCheckedIn());
    }


    @Test
    public void shouldCheckIfBookExistsInBookListAndReturnErrorMessage() {

    }

    @Test
    public void shouldCheckIfBookIsAlreadyCheckedout() {

    }

    @Test
    public void shouldSetBookToCheckedinAndReturnBook() {
        List<Book> bookList = library.createBookList();
        library.returnBook("Head First Java");
        assertEquals(true, bookList.get(0).getCheckedIn());

    }

}
