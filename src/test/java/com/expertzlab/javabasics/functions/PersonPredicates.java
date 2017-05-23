package com.expertzlab.javabasics.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by gireeshbabu on 22/05/17.
 */
public class PersonPredicates {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A1","F",21));
        persons.add(new Person("A2","M",23));
        persons.add(new Person("A3","F",25));
        persons.add(new Person("A4","M",26));
        PersonPredicates pp = new PersonPredicates();
        List<Person> resultList = pp.customFilter(persons,
                pp.getAdultMales());
        for(Person p: resultList){
            System.out.println(p.getFirstName());
        }
    }

    public Predicate<Person> getFemailPredicate(){

        return p -> p.getGender().equals("F");

    }

    public Predicate<Person> getAdultMales(){
        return p -> p.getAge() > 23 && p.getGender().equals("M");
    }

    public List<Person> customFilter(List<Person> persons, Predicate<Person> pred){
       return persons.stream().filter(pred).collect(Collectors.toList());
    }

}
