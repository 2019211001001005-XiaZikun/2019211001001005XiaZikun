package com.XiaZikun.week11.demo;

public class Person {
    private String name;
    private Dog dog;
    public Person(){}

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
