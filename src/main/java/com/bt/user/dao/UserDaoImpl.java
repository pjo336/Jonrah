package com.bt.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bt.user.User;

public class UserDaoImpl implements UserDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
    
    @Transactional
    public List<User> getUsers() {
        @SuppressWarnings("unchecked")
        List<User> userlist = sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return userlist;
    }
}
