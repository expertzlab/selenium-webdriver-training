package com.expertzlab.javabasics.generics;

import java.util.concurrent.Callable;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public class MainCalculator {

    public static void main(String[] args) {

        Calculator<Money> m1 = new Calculator<Money>();
        float result = m1.processDouble(new DollarCurrency(34));

        System.out.println("P Result =" + result);
        float result1 = m1.processDouble(new PoundCurrency(34));

        System.out.println("P Result =" + result1);
    }
}
