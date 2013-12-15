package com.bt.user.dao;

import java.util.List;

import com.bt.user.User;

public interface UserDao {
    
    public void saveUser(User user);
    public List<User> getUsers();

}
