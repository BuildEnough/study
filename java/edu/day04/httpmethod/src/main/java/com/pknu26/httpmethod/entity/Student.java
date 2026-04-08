package com.pknu26.httpmethod.entity;

// 나중에 DB와 연결될 부분
public class Student {
    private String name;
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    

    
}
