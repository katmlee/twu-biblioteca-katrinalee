package com.twu.biblioteca;

/**
 * Created by katrinalee on 1/4/17.
 */
public class User {
    private String name;
    private String email;
    private String phone;
    private int libaryNumber;
    private String password;

    public User (String name, String email, String phone, int libaryNumber, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libaryNumber = libaryNumber;
        this.password = password;
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

    public int getLibaryNumber(){
        return libaryNumber;
    }

    public String getPassword(){
        return password;
    }

    public void setLibaryNumber(int libaryNumber){
        this.libaryNumber = libaryNumber;
    }

    @Override
    public String toString(){
        return "\n User name: " + this.getName() + " Email: " + this.getEmail() + " Phone: " + this.getPhone()+ "\n";
    }

}
