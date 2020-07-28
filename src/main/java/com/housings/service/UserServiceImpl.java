package com.housings.service;


import com.housings.dao.UserDao;
import com.housings.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByNamePassword(String name, String password){
        return userDao.getUserByNamePassword(name,password);
    }

    @Override
    public void deleteUser(List<Integer> ids) {
        userDao.deleteUser(ids);
    }
    @Override
    public List<User> queryAll() {
        //return userDao.queryAll();
        return  null;
    }
    @Override
    public void updateUser(User u) {
        userDao.updateUser(u);
    }
    @Override
    public void insertUser(User u) {
        userDao.insertUser(u);
    }

    @Override
    public User validate(String username) {
        return userDao.validate(username);
    }
}
