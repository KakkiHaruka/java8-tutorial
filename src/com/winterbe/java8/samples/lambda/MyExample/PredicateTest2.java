package com.winterbe.java8.samples.lambda.MyExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest2 {
    public static void main(String[] args) {
        User user1 = new User("张三", "男", 21);
        User user2 = new User("李四", "女", 22);
        User user3 = new User("张三", "男", 23);

        List<User> list = Arrays.asList(user1, user2, user3);

        /**
         * 获取年龄大于2的对象
         */
        List<User> collect = list.stream().filter(x -> x.getAge() > 2).collect(Collectors.toList());
        System.out.println("年龄大于2的人: " + collect);

        /**
         * 去重
         * 根据名字去重
         */
        List<User> collect2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("去重之后剩余: " + collect2);

        /**
         * 3、从集合中找出与该元素相同的元素 同样的name即为相同对象
         */
        User user4 = new User("张三", "女", 12);
        Predicate<User> predicate = Predicate.isEqual(user4);
        List<User> collect3 = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("与该对象相同的有: " + collect3);
    }
}
