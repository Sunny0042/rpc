package com.sunny.bean;

import java.io.Serializable;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 15:26
 * @ModifyDate 2019-09-19 15:26
 */
public class User implements Serializable {
    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
