package com.winterbe.java8.samples.lambda.MyExample;

import java.util.function.Consumer;

public class ConsumerTest01 {

    /**
     * 定义一个方法，方法传递一个字符串的姓名，方法传递一个Consumer接口，泛型使用String，可以使用Consumer接口消费字符串的姓名
     *
     * 相当于定义一个行为去操作一个数据
     * @param name
     * @param con
     */
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args){
        // 对传递的字符串进行操作
        // 操作方式1:直接输出
        method("张三", System.out::println);
        // 操作方式2:倒序
        method("李四", (String name) -> {
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }

}
