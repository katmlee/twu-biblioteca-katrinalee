package com.twu.biblioteca;

/**
 * Created by katrinalee on 1/4/17.
 */
public class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;
    private boolean isLoggedIn;

    public User (String name, String email, String phone, String libraryNumber, String password, boolean isLoggedIn){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }

    public String getPassword(){
        return password;
    }

    public boolean getIsLoggedIn(){
        return isLoggedIn;
    }

    public void setLibraryNumber(String libaryNumber){
        this.libraryNumber = libaryNumber;
    }

    public void setIsLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString(){
        return "\n User name: " + this.getName() + " Email: " + this.getEmail() + " Phone: " + this.getPhone()+ "Library Number: " + this.getLibraryNumber() + "Password " + this.getPassword() +"Logged In "+ this.getIsLoggedIn() +"\n";
    }

}
