package com.winterbe.java8.samples.lambda;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        // 需要提供一个匿名比较器
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // java8更短，不需要提供匿名的比较器
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        // 更短
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        // 更短
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //更短
        names.sort((a, b) -> b.compareTo(a));
        System.out.println(names);

        names.sort(Collections.reverseOrder());

        System.out.println(names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);

        // MyExample1
        List<Integer> intList = Arrays.asList(1, 2, 3, -1, 40, 23);

//        intList.sort((a, b) -> a.compareTo(b));

        // 更短，替换建议
        intList.sort(Integer::compareTo);
        System.out.println(intList);
    }

}