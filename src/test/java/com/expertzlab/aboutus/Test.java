package com.expertzlab.aboutus;

/**
 * Created by gireeshbabu on 13/05/17.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("Hello");
        int s = sum(20, 34);
        assert s == 54: "This value should be equal";

    }

    private static int sum(int a, int b){
        return a + b;
    }
}
