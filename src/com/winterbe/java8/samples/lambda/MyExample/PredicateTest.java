package com.winterbe.java8.samples.lambda.MyExample;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        /**
         * 1、判断数字是否大于7
         */
        // 设置一个大于7的过滤条件
        Predicate<Integer> predicate = x -> x > 7;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(3));
        /**
         * 2、大于7并且
         */
        // 在上边大于7的情况下，添加是偶数的条件
        predicate = predicate.and(x -> x % 2 == 0);
        System.out.println(predicate.test(6));
        System.out.println(predicate.test(12));
        System.out.println(predicate.test(13));
        /**
         *3、 and or 简化写法
         */
        predicate = x -> x > 5 && x < 9;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(6));

    }

}
