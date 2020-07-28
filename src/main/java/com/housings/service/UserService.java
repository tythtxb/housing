package com.housings.service;

import com.housings.pojo.User;

import java.util.List;

public interface UserService {
    public User getUserByNamePassword(String name, String password);

    public void deleteUser(List<Integer> ids);

    public List<User> queryAll();

    public void updateUser(User u);

    public void insertUser(User u);

    User validate(String username);
}
