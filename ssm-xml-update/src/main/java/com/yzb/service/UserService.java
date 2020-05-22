package com.yzb.service;

import com.yzb.entity.User;

import java.util.List;

public interface UserService {

    int saveUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryById(int id);

    List<User> queryAllUser();
}
