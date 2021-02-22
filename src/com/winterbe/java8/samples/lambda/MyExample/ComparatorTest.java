package com.winterbe.java8.samples.lambda.MyExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {
        ArrayList<Entity> list = new ArrayList<Entity>();
        list.add(new Entity("李四", 24));
        list.add(new Entity("张三", 13));
        list.add(new Entity("王五", 25));
        System.out.println("排序前：" + list);
        Collections.sort(list, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("排序后：" + list);
    }
}

class Entity {
    String name;
    int age;

    public Entity(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity [name=" + name + ", age=" + age + "]";
    }
}
