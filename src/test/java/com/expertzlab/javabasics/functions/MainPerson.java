package com.expertzlab.javabasics.functions;

import java.util.function.Function;

/**
 * Created by gireeshbabu on 22/05/17.
 */
public class MainPerson {

    public static void main(String[] args) {

        Person p = new Person();
        p.setFirstName("Expertz");
        p.setLastName("Lab");
        p.setDate("2017/2/23");

        Function <Person, String> fun1 =  p1 -> {
            return p1.getFirstName() + " " +
                    p1.getLastName()+ " "+
                    p1.getDate();
        };

        Function <Person, String> fun2 =  p1 -> {
            return p1.getDate() + " "+ p1.getFirstName() + " " +
                    p1.getLastName();
        };


        System.out.println(p.printCustom(fun1));
        System.out.println(p.printCustom(fun2));

    }
}
