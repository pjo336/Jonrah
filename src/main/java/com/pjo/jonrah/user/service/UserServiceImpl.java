package com.pjo.jonrah.user.service;

import com.pjo.jonrah.entity.dao.EntityDao;
import com.pjo.jonrah.exceptions.NotFoundException;
import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.UserType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    EntityDao entityDao;

    @Override
    public void addUser(User user) {
        if(user != null) {
            String saltPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(saltPassword);
            if(user.getUserType() == null) {
                user.setUserType(UserType.GENERIC);
            }
            entityDao.add(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if(user != null) {
            entityDao.saveOrUpdate(user);
        }
    }

    @Override
    public void removeUser(User user) {
        if(user != null) {
            entityDao.remove(user);
        }
    }

    @Override
    public User restoreUserById(long id) throws NotFoundException {
        Criteria crit = entityDao.createCrit(new User());
        crit.add(Restrictions.eq("id", id));
        List<User> userList = entityDao.findCritList(crit);
        if(userList.size() > 0 && userList.get(0) != null) {
            return userList.get(0);
        } else {
            throw new NotFoundException("A user with this id does not exist");
        }
    }

    @Override
    public User restoreUserByLogin(String login) throws NotFoundException {
        Criteria crit = entityDao.createCrit(new User());
        crit.add(Restrictions.like("userName", login));
        List<User> userList = entityDao.findCritList(crit);
        if(userList.size() > 0 && userList.get(0) != null) {
            return userList.get(0);
        } else {
            throw new NotFoundException("A user with this login does not exist");
        }
    }

    @Override
    public List<User> findAllUsers() {
        Criteria crit = entityDao.createCrit(new User());
        return entityDao.findCritList(crit);
    }

    @Override
    public void removeUserById(long id) throws NotFoundException {
        User userToRemove = restoreUserById(id);
        if(userToRemove != null) {
            entityDao.remove(userToRemove);
        } else {
            throw new NotFoundException("A user with this id does not exist");
        }
    }
}