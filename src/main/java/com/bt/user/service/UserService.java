package com.bt.user.service;

import com.bt.user.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    public void addUser(User user);
    public List<User> getUsers();
    public User findUserById(int id);
    public void deleteUser(User user);
    public void deleteUserById(int id) throws NotFoundException;
}
