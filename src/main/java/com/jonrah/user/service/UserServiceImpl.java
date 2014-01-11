package com.jonrah.user.service;

import com.jonrah.user.User;
import com.jonrah.user.UserType;
import com.jonrah.user.dao.UserDao;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        if(user != null) {
            if(user.getUserType() == null) {
                user.setUserType(UserType.GENERIC);
            }
            user.setDateAdded(new Date());
            userDao.add(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if(user != null) {
            userDao.updateOrCreateUser(user);
        }
    }

    @Override
    public void removeUser(User user) {
        if(user != null) {
            userDao.remove(user);
        }
    }

    @Override
    public User restoreUserById(long id) throws NotFoundException {
        Criteria crit = userDao.createCrit(new User());
        crit.add(Restrictions.eq("id", id));
        List<User> userList = userDao.findCritList(crit);
        if(userList.size() == 1 && userList.get(0) != null) {
            return userList.get(0);
        } else {
            throw new NotFoundException("A user with this id does not exist");
        }
    }

    @Override
    public List<User> findUserByLogin(String login) {
        Criteria crit = userDao.createCrit(new User());
        crit.add(Restrictions.like("userName", login));
        return userDao.findCritList(crit);
    }

    @Override
    public List<User> findAllUsers() {
        Criteria crit = userDao.createCrit(new User());
        return userDao.findCritList(crit);
    }

    @Override
    public void removeUserById(long id) throws NotFoundException {
        User userToRemove = restoreUserById(id);
        if(userToRemove != null) {
            userDao.remove(userToRemove);
        } else {
            throw new NotFoundException("A user with this id does not exist");
        }
    }
}