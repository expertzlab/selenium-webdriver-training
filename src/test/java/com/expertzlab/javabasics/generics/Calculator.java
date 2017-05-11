package com.expertzlab.javabasics.generics;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public class Calculator<T> {

    public <T extends Money> float processDouble(T m){
        return m.getRupeeValue() * 2;
    }
}
