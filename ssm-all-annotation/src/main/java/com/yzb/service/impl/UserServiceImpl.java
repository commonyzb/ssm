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

    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    public List<User> listUser() {
        return userDao.listUser();
    }

}
