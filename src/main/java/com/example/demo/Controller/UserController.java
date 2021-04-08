package com.example.demo.Controller;

import com.example.demo.model.User;
import com.example.demo.service.iml.UserServiceIml;
import com.example.demo.utlis.RuturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /**
     * 保存用户 API
     * @param request HttpServletRequest
     * @return 是否保存成功 返回值
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(HttpServletRequest request) {

        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        if (age < 0 || age > 120) {
            return ruturnMessage.failure("年龄参数出错，请检查");
        }
        User user = new User(username, age, sex);
        try {
            userServiceIml.saveUser(user);
            return "Code:200,message:save ok";
        } catch (Exception e) {
            String errorMessage = String.valueOf(e);
            return errorMessage;
        }
    }

    /**
     *  使用id查询用户
     * @param id 查询的id
     * @return 返回查询到底的user信息
     */
    @RequestMapping(value = "finduser", method = RequestMethod.GET)
    @ResponseBody
    public Object findUser(@RequestParam("id") int id) {
        User user = null;
        try {
            user = (User) userServiceIml.getUserById(id);
            if (user.getId()==id) {
                return user;
            }
        } catch (Exception e) {
            return ruturnMessage.failure("用户不存在");
        }
        System.out.println(user.getSex());
        return ruturnMessage.failure("用户不存在");
    }


}
