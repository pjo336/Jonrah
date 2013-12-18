package com.bt.user.dao;

import com.bt.genericdao.GenericDaoImpl;
import com.bt.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserById(long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
}
