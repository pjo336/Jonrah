package com.bt.user.dao;

import com.bt.genericdao.GenericDao;
import com.bt.genericdao.GenericDaoImpl;
import com.bt.user.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Long> {

    public User findUserById(long id);
}
