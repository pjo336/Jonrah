package com.jonrah.user.dao;

import com.jonrah.genericdao.GenericDao;
import com.jonrah.user.User;

public interface UserDao extends GenericDao<User, Long> {

    /**
     * Returns the user based on the given Id
     * @param id
     * @return
     */
    public User findUserById(long id);
}
