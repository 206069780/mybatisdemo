package com.example.demo.service;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @packageName: com.example.demo.service
 * @program: mybatisdemo
 * @className: UserService
 * @author: Mr.FU
 * @ @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:19
 * @description: userService interface
 **/
public interface UserService {
    /**
     * 保存用户的基本信息
     * @param user
     * @return 保存的用户数量
     */
    public int saveUser( @Param("user") User user);

    /**
     * 根据id移除用户
     * @param id 用户id
     * @return 删除的用户数量
     */
    public int removeUserById(@Param("id") int id);

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 返回用户bean
     */
    public Object getUserById(@Param("id") int id);

    /**
     * 获取所有的用户数据
     * @return 查询的用户数据
     */
    public List<User> getAllUsers();

    /**
     * 根据id判断用户是否存在
     * @param id 用户id
     * @return 返回用户是否存在？true：false
     */
    public boolean hasUserById(@Param("id") int id);
}
