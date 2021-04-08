package com.example.demo.utlis;

import com.example.demo.bean.ResultBean;
import org.springframework.stereotype.Component;

/**
 * @PackageName com.example.demo.utlis
 * @ProjectName demo
 * @ClassNmae RuturnMessage
 * @Author Administrator
 * @Date 2021/4/8 10:28
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description 请求结果返回
 */
@Component
public class RuturnMessage {

    public Object success(String message){
        return new ResultBean(200,message);
    }

    public Object failure(String errorMessage){
        return new ResultBean(400,"Request failed",errorMessage);
    }
}
