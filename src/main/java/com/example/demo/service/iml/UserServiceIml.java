package com.example.demo.service.iml;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName: com.example.demo.service.iml
 * @program: mybatisdemo
 * @className: UserServiceIml
 * @author: Mr.FU
 * @ @Email: fudaopin@gmail.com
 * @createDate: 2021-04-07  23:20
 * @description: TODO
 **/

@Service
public class UserServiceIml  implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int removeUserById(int id) {
        return 0;
    }

    @Override
    public Object getUserById(int id) {
        return null;
    }

    @Override
    public List<Object> getAllUsers() {
        return null;
    }

    @Override
    public boolean hasUserById(int id) {
        return userDao.getUserById(id)==null?true:false;
    }
}
