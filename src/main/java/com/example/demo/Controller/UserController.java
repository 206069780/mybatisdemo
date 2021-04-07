package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.RequestBean;
import com.example.demo.model.User;
import com.example.demo.service.iml.UserServiceIml;
import com.example.demo.utlis.RuturnMessage;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @packageName: com.example.demo.Controller
 * @program: mybatisdemo
 * @className: UserController
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:33
 * @description: userController 对用户操作
 **/

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceIml userServiceIml;

    @Autowired
    RuturnMessage ruturnMessage;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(HttpServletRequest request) {

        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        if (age < 0 || age > 120) {
            return ruturnMessage.failure("参数错误");
        }
        User user = new User(username, age, sex);
        try {
            userServiceIml.saveUser(user);
            return "Code:200,message:save ok";
        } catch (Exception e) {
            String errorMessage = String.valueOf(e);
            return e;
        }
    }

    @RequestMapping(value = "finduser", method = RequestMethod.GET)
    @ResponseBody
    public Object findUser(@RequestParam("id") int id) {
        User user = null;
        try {
            user = (User) userServiceIml.getUserById(id);
            if (user != null) {
                return user;
            }
        } catch (Exception e) {
            return e.toString();
        }
        return null;
    }


}
