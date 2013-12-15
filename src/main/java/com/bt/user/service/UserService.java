package com.bt.user.service;

import java.util.List;

import com.bt.user.User;

public interface UserService {

    public void addUser(User user);
    public List<User> getUsers();
}
