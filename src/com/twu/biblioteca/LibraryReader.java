package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

/**
 * Created by klee on 13/1/17.
 */
public class LibraryReader {

    private InputStream systemIn;

    public String getReading(String prompt){
        String userInput = null;
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        userInput = input.nextLine();
        return userInput;

    }
}
