package com.bt.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bt.user.User;
import com.bt.user.dao.UserDao;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    
    public void addUser(User user) {
        userDao.saveUser(user);
    }
    
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
