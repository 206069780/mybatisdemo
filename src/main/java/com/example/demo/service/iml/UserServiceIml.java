package com.example.demo.service.iml;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName: com.example.demo.service.iml
 * @program: mybatisdemo
 * @className: UserServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:20
 * @description: TODO
 **/

@Service
public class UserServiceIml implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Override
    public int saveUser(@Param("user") User user) {
        return userDao.saveUser(user);
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return
     */
    @Override
    public int removeUserById(@Param("id") int id) {
        return userDao.removeUserById(id);
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return
     */
    @Override
    public Object getUserById(@Param("id") int id) {
        return userDao.getUserById(id);
    }

    /**
     * 获取所有的用户数据
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * 判断用户是否存在
     *
     * @param id 用户id
     * @return
     */
    @Override
    public boolean hasUserById(@Param("id") int id) {
        return userDao.getUserById(id) == null ? true : false;
    }
}
