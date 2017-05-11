package com.expertzlab.javabasics.generics;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public abstract class Money {

    float value;

    public Money(float v){
        value = v;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    abstract float getRupeeValue();
}
