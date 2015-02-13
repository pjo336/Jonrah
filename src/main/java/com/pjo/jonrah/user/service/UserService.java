package com.pjo.jonrah.user.service;

import com.pjo.jonrah.user.User;
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
     * Returns the user with the given login. Throws a not found exception if no user is found
     * @param login
     * @return 1 user with this login, or throws a not found exception. If multiple users exist,
     * the first found is returned
     */
    public User restoreUserByLogin(String login) throws NotFoundException;

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
