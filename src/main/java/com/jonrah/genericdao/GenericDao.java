package com.jonrah.genericdao;

import javassist.NotFoundException;

import java.util.List;

/**
 * Created by pjo336 on 12/17/13
 * biggertime
 */
public interface GenericDao<E, K> {

    /**
     * Add the entity to the database
     * @param entity in database
     */
    void add(E entity);

    /**
     * Update the entity with the new value
     * @param entity in database
     */
    void update(E entity);

    /**
     * Remove the entity
     * @param entity in database
     */
    void remove(E entity);

    /**
     * Find the entity based on the given primary key
     * @param key primary key of entity
     * @return
     */
    public E restore(K key) throws NotFoundException;

    /**
     * Return a list of all the entities in the database
     * @return
     */
    List<E> list();
}
