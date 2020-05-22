package com.yzb.dao;


import com.yzb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
 * 连接数据库操作user表
 */
public interface UserDao {

    /*
     * CRUD
     */

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("INSERT INTO user(user_name,password) VALUES(#{userName},#{password}) ")
    int saveUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id} ")
    int deleteUserById(int id);

    @Update("UPDATE user SET user_name=#{userName},password=#{password} WHERE id=#{id} ")
    int updateUser(User user);

    @Select("SELECT * FROM user WHERE id=#{id} ")
    User getUserById(int id);

    @Select("SELECT * FROM user WHERE user_name=#{userName} ")
    User getUserByName(String userName);

    @Select("SELECT * FROM user ")
    List<User> listUser();

}
