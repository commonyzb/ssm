package com.yzb.dao;

import com.yzb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    int saveUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryById(int id);

    List<User> queryAllUser();

}
