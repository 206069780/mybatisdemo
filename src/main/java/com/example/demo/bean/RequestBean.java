package com.example.demo.bean;

import java.io.Serializable;

/**
 * @PackageName com.example.demo.bean
 * @ProjectName demo
 * @ClassNmae RequestBean
 * @Author Administrator
 * @Date 2021/4/8 10:49
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description Josn请求参数封装
 */
public class RequestBean implements Serializable {

    public static final long serialVersionUID = 1L;

    //用户id
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
