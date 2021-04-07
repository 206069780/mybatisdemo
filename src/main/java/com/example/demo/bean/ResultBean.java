package com.example.demo.bean;

import com.mysql.cj.protocol.x.XMessage;

/**
 * @PackageName com.example.demo.bean
 * @ProjectName demo
 * @ClassNmae ResultBean
 * @Author Administrator
 * @Date 2021/4/8 10:31
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description 请求结果bean
 */
public class ResultBean {

    //请求的结果
    private int code;
    //请求的结果描述
    private String message;

    private String errorMessage;

    public ResultBean(int code, String message, String errorMessage) {
        this.code = code;
        this.message = message;
        this.errorMessage = errorMessage;
    }
    public ResultBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //返回结果的封装
    @Override
    public String toString() {
        return "{code:" + code +", message:'" + message +'}';
    }
}
