package com.jonrah.user.dao;

import com.jonrah.genericdao.GenericDaoImpl;
import com.jonrah.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
    
    @Override
    public User findUserById(long id) {
        return super.find(id);
    }
}
