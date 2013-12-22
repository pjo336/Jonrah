package com.jonrah.user.dao;

import com.jonrah.genericdao.GenericDao;
import com.jonrah.user.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Long> {

    /**
     * Returns the user based on the given Id
     * @param id
     * @return
     */
    public User findUserById(long id);

    /**
     * Returns the user based on the given login
     *
     * @param login
     * @return
     */
    public List<User> findUserByLogin(String login);
}
