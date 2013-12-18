package com.bt.user.dao;

import com.bt.genericdao.GenericDaoImpl;
import com.bt.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    
    @Override
    public User findUserById(long id) {
        return super.find(id);
    }
}
