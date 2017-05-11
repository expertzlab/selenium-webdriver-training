package com.expertzlab.javabasics.annonymousclass;

/**
 * Created by gireeshbabu on 11/05/17.
 */
public class TestMain {

    public static void main(String[] args) {
        Test test = new Test(){
            public void testThis() {
                System.out.println("Inside test this");
            }
        };
        test.testThis();
        test = new Test(){

            public void testThis() {
                System.out.println("Again in Test this");
            }
        };
        test.testThis();
    }
}
