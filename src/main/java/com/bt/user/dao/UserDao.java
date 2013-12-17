package com.bt.user.dao;

import com.bt.user.User;

import java.util.List;

public interface UserDao {
    
    public void saveUser(User user);
    public List<User> getUsers();
    public User findUserById(int id);
    public void deleteUser(User user);

}
