package com.jonrah.user.service;

import com.jonrah.user.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    /**
     * Add a user to the database. If they have no userType set, it will default to GENERIC
     * @param user
     */
    public void addUser(User user);

    /**
     * If the user exists, update them to whatever is set in the user parameter, otherwise add the user to the database
     * @param user
     */
    public void updateUser(User user);

    /**
     * If the user exists, remove them from the database. Otherwise, nothing happens
     * @param user
     */
    public void removeUser(User user);

    /**
     * Return the user with the given id. Throw a not found exception if no user is found
     * @param id
     * @return
     * @exception NotFoundException
     */
    public User restoreUserById(long id) throws NotFoundException;

    /**
     * Returns a list of the users with the given login
     * NOTE: since login is unique this should only return a list of size 1. We could change this to restore?
     * @param login
     * @return
     */
    public List<User> findUserByLogin(String login);

    /**
     * Return all users in the database
     * @return
     */
    public List<User> findAllUsers();

    /**
     * Remove the user with the given Id
     * @param id
     * @throws NotFoundException
     */
    public void removeUserById(long id) throws NotFoundException;
}
