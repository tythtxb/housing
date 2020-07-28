package com.housings.dao;

import com.housings.pojo.SmokeAlarm;
import com.housings.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Repository
@Mapper
public interface UserDao {

    User getUserByNamePassword(@Param("username") String name, @Param("password") String password);

    void deleteUser(@Param("id")List<Integer> ids);

    List<User> queryAll();

    void updateUser(User u);

    void insertUser(User u);

    User validate(@Param("username")String username);

    int countItem();

    List<User> searchUser(@Param("name") String name);

    User findByUserId(User user);

    void delete(@Param("id") int id);
}

