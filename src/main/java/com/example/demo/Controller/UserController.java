package com.example.demo.Controller;

import com.example.demo.model.User;
import com.example.demo.service.iml.UserServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save() {

        User user = new User(1, "小弟弟", 120, "男");
        try {
            userServiceIml.saveUser(user);
            return "Code:200,message:save ok";
        } catch (Exception e) {
            String errorMessage = String.valueOf(e);
            return e;
        }
    }
}
