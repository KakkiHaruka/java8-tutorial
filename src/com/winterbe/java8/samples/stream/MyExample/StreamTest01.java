package com.winterbe.java8.samples.stream.MyExample;


import java.util.*;

import static java.util.stream.Collectors.toList;

public class StreamTest01 {

    public static void main(String[] args) throws Exception {
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

        System.out.println(list.stream().anyMatch(person -> person.getAge() > 20));

        System.out.println(list.stream().allMatch(person -> person.getName().equals("mike")));

        System.out.println(list.stream().noneMatch(person -> person.getAge() > 50));

//        // findAny返回的是一个Optional容器，但是如果找不到合适的就会不处理而不是返回
//        Optional<Person> person = list.stream().filter(person1 -> person1.getAge() > 50).findAny();
//
//        // 设定为空的时候抛出异常->不存在
//        person.orElseThrow(() -> new Exception("不存在"));

        // findAny返回的是一个Optional容器，但是如果找不到合适的就会不处理而不是返回
        Optional<Person> person = list.stream().filter(person1 -> person1.getAge() > 20).findAny();

        // 设定为空的时候报错不存在
        person.orElseThrow(() -> new Exception("不存在"));
        // 当存在的时候对Optinal容器中的对象x做一系列操作
        person.ifPresent(x -> System.out.println(x.getAge()));

        // reduce  用于组合中的元素，求和，求积等
        // 有点像hadoop的mapReduce，先用map拆开，在用reduce合并处理数据
        // reduce第一个参数没有的话，返回的是一个Optinal
        int sum = list.stream().map(Person::getAge).reduce(0, Integer::sum);
        System.out.println(sum);

        // count
        long count = list.stream().count();
        System.out.println(count);


    }


}
