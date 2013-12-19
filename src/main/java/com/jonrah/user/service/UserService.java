package com.jonrah.user.service;

import com.jonrah.user.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    /**
     * Add a user to the database
     * @param user
     */
    public void addUser(User user);

    /**
     * Update a user in the database
     * @param user
     */
    public void updateUser(User user);

    /**
     * Remove a user from the database
     * @param user
     */
    public void removeUser(User user);

    /**
     * Find the user with the given Id
     * @param id
     * @return User
     */
    public User findUserById(long id) throws NotFoundException;

    /**
     * Return all users in the database
     * @return
     */
    public List<User> getAllUsers();

    /**
     * Remove the user with the given Id
     * @param id
     * @throws NotFoundException
     */
    public void removeUserById(long id) throws NotFoundException;
}
