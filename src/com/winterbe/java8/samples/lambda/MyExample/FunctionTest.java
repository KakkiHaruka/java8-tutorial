package com.winterbe.java8.samples.lambda.MyExample;

import java.util.function.Function;

public class FunctionTest {


    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
//        System.out.println(functionTest.test());
        functionTest.test2();
        functionTest.test3();
        functionTest.test4();
    }

    /**
     * 1、简单测试
     */
    public int test() {
        Function<Integer, Integer> test = i -> i + 1;
        return test.apply(5);
    }

    /**
     * 函数式编程的思想是先不去考虑具体的行为，而是先去考虑参数，具体的方法我们可以后续再设置
     */
    public void test2() {
        Function<Integer, Integer> test1 = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i * i;
        System.out.println(calculate(test1, 5));
        System.out.println(calculate(test2, 5));
    }

    public static Integer calculate(Function<Integer, Integer> test, Integer number) {
        return test.apply(number);
    }

    /**
     * 实际开发中的逻辑可能很复杂，比如两个方法F1,F2都需要两个个逻辑AB，但是F1需要A->B，F2方法需要B->A。这样的我们用刚才的方法也可以实现
     */
    public void test3() {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        System.out.println("F1: " + B.apply(A.apply(5)));
        System.out.println("F2: " + A.apply(B.apply(5)));
    }

    /**
     * 假如我们F1,F2需要四个逻辑ABCD，那我们还这样写就会变得很麻烦了
     * compose和andThen可以解决我们的问题
     */

    /**
     * compose接受一个Function参数，返回时先用传入的逻辑执行apply，然后使用当前Function的apply
     * andThen跟compose正相反，先执行当前的逻辑，在执行传入的逻辑
     */
    public void test4() {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        System.out.println("F1: " + B.apply(A.apply(5)));
        System.out.println("F1: " + B.compose(A).apply(5));
        System.out.println("F2: " + A.apply(B.apply(5)));
        System.out.println("F2: " + B.andThen(A).apply(5));
        System.out.println(B.compose(A).compose(A).andThen(B).apply(5));
    }


}
