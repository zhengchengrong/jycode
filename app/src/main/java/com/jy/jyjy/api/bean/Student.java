package com.jy.jyjy.api.bean;

/**
 * Created by zcr on 2017/5/26.
 */


public class Student {
    private int age;
    private String name;
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


