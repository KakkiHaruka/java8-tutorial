package com.winterbe.java8.samples.stream.MyExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {

    public static void main(String[] args) throws IOException {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        list.add(new Person("tom", 31));

        // int sum = list.stream().map(Person::getAge).reduce(0, Integer::sum);
        // 计算元素总和的方法其中暗含了装箱成本
        // map(Person::getAge) 方法过后流变成了 Stream<Integer> 类型
        // 而每个 Integer 都要拆箱成一个原始类型再进行 sum 方法求和，这样大大影响了效率

        IntStream intStream = list.stream().mapToInt(Person::getAge);
        // 数据流转流
        Stream stream = intStream.boxed();

        // 数值范围
        // 全闭区间
        IntStream.rangeClosed(1, 10).mapToObj(Integer::toString).reduce((s1, s2) -> s1 + "," + s2).ifPresent(System.out::println);
        // 左闭右开
        IntStream.range(1, 10).mapToObj(Integer::toString).reduce((s1, s2) -> s1 + "," + s2).ifPresent(System.out::println);

        // 数组创建流
        int[] a = {1, 2, 3, 4};
        Arrays.stream(a).forEach(System.out::println);
        Arrays.stream(a, 1, 3).forEach(System.out::println);

        // 文件生成流
//        Stream<String> stream1 = Files.lines(Paths.get("data.txt"));

        // 函数生成流
        // iterate 一次对每个新生成的值应用函数
        // 不停止就一直运行
//        Stream.iterate(0, n -> n + 2).forEach(System.out::println);


        // Collect
        List newlist = list.stream().map(Person::getAge).collect(Collectors.toList());
        newlist.stream().forEach(System.out::println);
        Map<Integer, Person> map = list.stream().collect(Collectors.toMap(Person::getAge, p -> p));

        Double average = list.stream().collect(Collectors.averagingInt(Person::getAge));
        OptionalDouble averageDouble = list.stream().mapToInt(Person::getAge).average();

        // summarizingInt，summarizingLong，summarizingDouble
        IntSummaryStatistics l = list.stream().collect(Collectors.summarizingInt(Person::getAge));
        // IntSummaryStatistics包含了计算出来的平均值，总数，总和，最值
        System.out.println(l.getMax());
        System.out.println(l.getAverage());
        System.out.println(l.getCount());
        System.out.println(l.getMin());
        System.out.println(l.getSum());

        // 取最大值
        Optional<Person> optional = list.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
        Optional<Person> optional1 = list.stream().max(Comparator.comparing(Person::getAge));

        // joining，对流里边的字符串进行连接
        String s = list.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(s);
        // 特别的
        // 第一个参数是链接，第二个是开头，第三个是结尾
        String s1 = list.stream().map(Person::getName).collect(Collectors.joining(" and ", "Today ", " play games."));
        System.out.println(s1);

        // groupingBy
        // 分组，返回的是Map
        Map<Integer, List<Person>> map1 = list.stream().collect(Collectors.groupingBy(Person::getAge));
        // 二级分组
        Map<Integer, Map<String, List<Person>>> map2 = list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName)));

        //按组收集数据
        Map<Integer, Integer> map3 = list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.summingInt(Person::getAge)));

        // partitioningBy 分区
        // 分区与分组的区别在于， 分区是按照true和false来进行的
        Map<Boolean, List<Person>> map4 = list.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 20));
        map4.entrySet().forEach(p -> {
            System.out.println(p.getKey().toString() + " = " + p.getValue());
        });
        

    }

}
