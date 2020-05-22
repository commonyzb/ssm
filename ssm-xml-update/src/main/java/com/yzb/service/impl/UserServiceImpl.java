package com.yzb.service.impl;

import com.yzb.dao.UserDao;
import com.yzb.entity.User;
import com.yzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }
}
