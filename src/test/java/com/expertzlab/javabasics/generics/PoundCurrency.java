package com.expertzlab.javabasics.generics;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public class PoundCurrency extends Money {

    public PoundCurrency(float v){
        super(v);
    }

    float getRupeeValue(){
        return value * 85;
    }
}
