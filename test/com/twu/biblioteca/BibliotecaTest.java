package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;

import java.util.*;

public class BibliotecaTest {

    @Before
    public void setUp() {
        BibliotecaApp tester = new BibliotecaApp();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        BibliotecaApp tester = new BibliotecaApp();
        assertEquals( tester.welcomeMessage(), "Welcome to your Biblioteca- your stop for all your library needs!");
    }

    @Test
    public void shouldCreateNewListOfBooks() {
        BibliotecaApp library = new BibliotecaApp();
        List<Book> bookList = library.createBookList();
        assertEquals(bookList.size(), 4);
    }

    @Test
    public void shouldCreateNewBook(){

    }

    @Test
    public void shouldCheckTheMenuPrintsOutAListOfOptions(){

    }

    @Test
    public void shouldPrintOutAListOfBooks(){

    }

    @Test
    public void shouldSetBookToCheckedOutAndReturnBook() {
        BibliotecaApp library = new BibliotecaApp();
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
        BibliotecaApp library = new BibliotecaApp();
        List<Book> bookList = library.createBookList();
        library.returnBook("Head First Java");
        assertEquals(true, bookList.get(0).getCheckedIn());

    }

}
