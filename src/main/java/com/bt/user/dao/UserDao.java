package com.bt.user.dao;

import com.bt.genericdao.GenericDao;
import com.bt.user.User;

public interface UserDao extends GenericDao<User, Long> {

    /**
     * Returns the user based on the given Id
     * @param id
     * @return
     */
    public User findUserById(long id);
}
