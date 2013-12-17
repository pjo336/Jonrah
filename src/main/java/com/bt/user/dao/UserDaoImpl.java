package com.bt.user.dao;

import com.bt.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
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
