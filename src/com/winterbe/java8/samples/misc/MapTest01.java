package com.winterbe.java8.samples.misc;

import com.winterbe.java8.samples.stream.MyExample.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest01 {

    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        list.add(new Person("tom", 31));
        // groupingBy
        // 分组，返回的是Map
        Map<Integer, List<Person>> map1 = list.stream().collect(Collectors.groupingBy(Person::getAge));
        // 把value中的list中的对象替换为对象中的某个属性
        Map<Object, Object> map2 = map1.keySet().stream().collect(Collectors.toMap(p -> p, p -> map1.get(p).stream().map(Person::getName).collect(Collectors.toList())));
        System.out.println(map2);
    }

}
