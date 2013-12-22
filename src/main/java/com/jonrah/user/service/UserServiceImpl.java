package com.jonrah.user.service;

import com.jonrah.user.User;
import com.jonrah.user.UserType;
import com.jonrah.user.dao.UserDao;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        if(user.getUserType()==null) {
            user.setUserType(UserType.GENERIC);
        }
        userDao.add(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void removeUser(User user) {
        userDao.remove(user);
    }

    @Override
    public User findUserById(long id) throws NotFoundException{
        return userDao.findUserById(id);
    }

    public List<User> findUserByLogin(String login) {
        return userDao.findByStringQuery(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.list();
    }

    @Override
    public void removeUserById(long id) throws NotFoundException {
        User user = findUserById(id);
        if(user != null) {
            userDao.remove(user);
        } else {
            throw new NotFoundException("A user with this id does not exist");
        }
    }
}