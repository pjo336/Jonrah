package com.bt.user.service;

import com.bt.user.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(User user);
    public User findUserById(long id);
    public List<User> getAllUsers();
    public void removeUserById(long id) throws NotFoundException;
}
