package com.winterbe.java8.samples.stream.MyExample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamTest01 {

    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        list.add(new Person("tom", 30));

        // filter
        list.stream()
                .filter(person -> person.getAge() >= 20)
                .forEach(person -> System.out.println(person.getName()));

        // sort
        list.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(person -> System.out.println(person.getName()));

        // distinct
        list.stream()
                .distinct()
                .forEach(person -> System.out.println(person.getName()));

        // limit
        list.stream()
                .limit(2)
                .forEach(person -> System.out.println(person.getName()));

        // skip
        list.stream()
                .skip(1)
                .forEach(person -> System.out.println(person.getName()));

        // map
        list.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        // flatMap
        List<String> flatMapList = new ArrayList<>();
        flatMapList.add("aaa bbb ccc");
        flatMapList.add("ddd eee fff");
        flatMapList.add("ggg hhh iii");

        flatMapList.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);


    }


}
