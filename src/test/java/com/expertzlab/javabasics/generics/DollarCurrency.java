package com.expertzlab.javabasics.generics;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public class DollarCurrency extends Money {

    public DollarCurrency(float v){
        super(v);
    }

    public float getRupeeValue(){
        return value *65;
    }
}
