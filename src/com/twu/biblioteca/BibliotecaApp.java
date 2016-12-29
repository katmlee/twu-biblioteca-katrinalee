package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();
    private boolean isALibraryBook;

    public String welcomeMessage(){
        return "Welcome to your Biblioteca- your stop for all your library needs!";
    }

    public ArrayList<Book>  displayBookList(){
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

    public String checkoutBook(String bookToCheckout){
        System.out.println(books);
        System.out.println(bookToCheckout);
        for (Book book : books) {
            if (book.getTitle().contains(bookToCheckout)) {
                isALibraryBook = true;
                if(book.getCheckedIn()) {
                    book.setCheckedIn(false);
                    //instead of removing the book add another field to book, boolean checked in?
                    System.out.println("Thanks for checking out " + bookToCheckout);
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
        for (Book book : books) {
            if (book.getTitle().contains(bookToCheckin)) {
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

    public void menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
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
        BibliotecaApp user = new BibliotecaApp();
        user.welcomeMessage();
        user.menu();
    }
}


//    *Welcome Message  - As a customer, I would like to see a welcome message when I start the application, so that I feel welcome and know that Biblioteca is available.
//print a welcome message introducing biblioteca
//        *List Books - As a customer, after the welcome message appears I would like to see a list of all library books, so that I can browse for books I might want to check-out. Assume that there is a pre-existing list of books. You don't need to support adding or removing books from the library.
//        *Book Details - As a customer, I'd like the list of all books to include each books Author and Year Published, so that I can be confident that I have found the book I am looking for. The book listing should have columns for this information.
//        *Main Menu  - As a customer, instead of automatically seeing the book list, I would like to see a list of options and be able to choose one. For now, the only option should be 'List Books'. All future options should be added to this menu also.
//        *Invalid Menu Option - As a customer, I would like to be notified when I choose an invalid option with the message “Select a valid option!”, so that I can know when I need to re-enter my choice.
//        *Quit - As a customer, I would like to continue choosing options until I choose to 'Quit'.
//        *Checkout Book - As a librarian, I would like customers to be able to check-out a book. Checked out books should not appear in the list of all library books.
//        *Successful Checkout - As a customer, I would like to know that a book has been checked out by seeing the message “Thank you! Enjoy the book”.
//        *Unsuccessful Checkout - As a customer, I would like to be notified if the book I tried to check-out is not available by seeing the message, “That book is not available.”, so that I know that I need to select a different book or fix my spelling error.
//        *Return Book - As a librarian, I would like customers to be able to return a book, so that other customers can check that book out. Returned books should appear in the list of library books.
//        *Successful Return - As a customer, I would like to be notified if the book I am returning belongs to this library by seeing the message, “Thank you for returning the book.”, so that I know I returned the book to the right library.
//        *Unsuccessful Return - As a customer, I would like to be notified if the book I am returning has not been added to this library by seeing the message, “That is not a valid book to return.”, so that I can return it to the correct library or fix my spelling error.