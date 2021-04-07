package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @packageName: com.example.demo.dao
 * @program: mybatisdemo
 * @className: UserDao
 * @author: Mr.FU
 * @ @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:09
 * @description: user的mapperdao接口，实现数据的持久化
 **/

@Mapper
public interface UserDao {

    /**
     * 保存用户的基本信息
     * @param user
     * @return 保存的用户数量
     */
    public int saveUser(User user);

    /**
     * 根据id移除用户
     * @param id 用户id
     * @return 删除的用户数量
     */
    public int removeUserById(int id);

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 返回用户bean
     */
    public Object getUserById(int id);

    /**
     * 获取所有的用户数据
     * @return 查询的用户数据
     */
    public List<Object> getAllUsers();

    /**
     * 根据id判断用户是否存在
     * @param id 用户id
     * @return 返回用户是否存在？true：false
     */
    public boolean hasUserById(int id);
}
