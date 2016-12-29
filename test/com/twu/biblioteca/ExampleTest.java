package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.*;
import org.junit.Test;

import java.util.*;

public class ExampleTest {

    @Test
    public void welcomeMessageTest() {
        BibliotecaApp l = new BibliotecaApp();
        assertEquals( l.welcomeMessage(), "Welcome to your Biblioteca- your stop for all your library needs!");
    }

    @Test
    public void displayBookListTest() {
        BibliotecaApp l = new BibliotecaApp();
        List<Book> bookList = l.displayBookList();
        assertEquals(bookList.size(), 4);
    }

    @Test
    public void checkoutBookTest() {
        BibliotecaApp l = new BibliotecaApp();
        List<Book> bookList = l.displayBookList();
        l.checkoutBook("Head First Java");
        assertEquals(false, bookList.get(0).getCheckedIn());
    }

    @Test
    public void returnBookTest() {
        BibliotecaApp l = new BibliotecaApp();
        List<Book> bookList = l.displayBookList();
        l.returnBook("Head First Java");
        assertEquals(true, bookList.get(0).getCheckedIn());

    }

}
