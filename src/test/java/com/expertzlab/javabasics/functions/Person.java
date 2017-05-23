package com.expertzlab.javabasics.functions;

import java.util.function.Function;

/**
 * Created by gireeshbabu on 22/05/17.
 */
public class Person {

    public Person(){

    }

    public Person(String fn, String gender, int age){
        this.gender = gender;
        this.age = age;
        this.firstName = fn;
    }

    String firstName;
    String lastName;
    String date;
    String gender;
    int age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String printCustom(Function <Person, String> f){
       return f.apply(this);
    }
}
