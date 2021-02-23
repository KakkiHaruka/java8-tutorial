package com.winterbe.java8.samples.stream.MyExample;

import java.util.Objects;

public class Person {

    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 如果使用stream中的distinct来对Person对象列表去重，就需要重写该方法
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        final Person person = (Person) obj;
        if (this == person) {
            return true;
        } else {
            return (this.name.equals(person.name) && this.age == person.age);
        }
    }

    /**
     * 如果使用stream中的distinct来对Person对象列表去重，就需要重写该方法
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
