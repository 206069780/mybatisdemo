package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import com.example.demo.service.iml.UserServiceIml;
import com.example.demo.utlis.RuturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * 保存用户 API 采用 HttpServletRequest 接受数据
     *
     * @param request HttpServletRequest
     * @return 是否保存成功 返回值
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(@RequestBody JSONObject request){
        String username;
        String sex;
        int age;
        try {
            username = (String) request.get("username");
            sex = (String) request.get("sex");
            age = Integer.parseInt((String) request.get("age")) ;
        } catch (NullPointerException exception) {
            return ruturnMessage.failure("参数不能为空，请检查");
        }
        System.out.println("name:"+username+",sex:"+sex+",age:"+age);
        if (username == null || username.equals("") || sex == null || sex.equals("") || age >= 140 || age <= 0) {
            return ruturnMessage.failure("参数出错，请检查");
        }
        User user = new User(username, age, sex);
        try {
            userServiceIml.saveUser(user);
            return ruturnMessage.success("用户保存成功");
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    /**
     * 使用id查询用户
     *
     * @param id 查询的id
     * @return 返回查询到底的user信息
     */
    @RequestMapping(value = "finduser", method = RequestMethod.GET)
    @ResponseBody
    public Object findUser(@RequestParam("id") int id) {
        try {
            if (userServiceIml.hasUserById(id)) {
                return (User) userServiceIml.getUserById(id);
            }
        } catch (Exception e) {
            System.out.print(id + "e");
            return ruturnMessage.failure("用户不存在");
        }
        return ruturnMessage.failure("用户不存在");
    }

    /**
     * 根据id删除用户 先判断id是否存在 存在在执行删除操作 ，否则返回 ”没有该用户“
     *
     * @param request 传递用户id
     * @return 返回删除是否成功结果
     */
    @RequestMapping(value = "dele", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = (User) userServiceIml.getUserById(id);
        try {
            if (userServiceIml.hasUserById(id)) {
                if (userServiceIml.removeUserById(id) > 0) {
                    return ruturnMessage.success("删除" + user.getUsername() + "成功");
                } else {
                    ruturnMessage.failure("删除失败！请过会再尝试");
                }
            }
        } catch (Exception e) {
            return ruturnMessage.failure("没有该用户");
        }
        return ruturnMessage.failure("没有该用户");
    }

    /**
     * 获取所有的用户数据
     *
     * @return list<user>
     */
    @RequestMapping(value = "getall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        List<User> list = userServiceIml.getAllUsers();
        return list;
    }


}
