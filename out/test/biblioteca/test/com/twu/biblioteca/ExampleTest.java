package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class ExampleTest {

    @Test
    public void welcomeMessageTest() {
        BibliotecaApp u = new BibliotecaApp();
        assertEquals( u.welcomeMessage(), "Welcome to your Biblioteca- your stop for all your library needs!");
    }

    @Test
    public void displayBookListTest() {
        BibliotecaApp u = new BibliotecaApp();
        List<Book> bookList = u.displayBookList();
        Assert.assertEquals(bookList.size(), 4);

    }
}
