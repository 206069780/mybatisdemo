package com.example.demo.model;

import java.io.Serializable;

/**
 * @packageName: com.example.demo.model
 * @program: mybatisdemo
 * @className: User
 * @author: Mr.FU
 * @ @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:04
 * @description: 定义user bean
 **/
public class User implements Serializable {

    //Serializable 标识
    public static final long serialVersionUID = 1L;

    //用户 id AUTO_INCREMENT
    private int id;

    //用户名
    private String username;

    //用户 年龄
    private int age;

    //用户性别
    private String sex;

    public User(int id, String username, int age, String sex) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
