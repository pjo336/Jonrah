package com.jonrah.entity.dao;

import com.jonrah.entity.JonrahEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

/**
 * Every DAO Interface must extend this interface
 */
public interface EntityDao<E extends JonrahEntity> {

    /**
     * Create and return a Criteria object. Can be used in the service layer to create custom criteria queries
     * @return
     */
    public Criteria createCrit(JonrahEntity clazz);

    /**
     * Add the entity to the database
     * @param entity in database
     */
    public void add(JonrahEntity entity);

    /**
     * Update the entity with the new value
     * @param entity in database
     */
    public void update(JonrahEntity entity);

    /**
     * Remove the entity
     * @param entity in database
     */
    public void remove(JonrahEntity entity);

    /**
     * Find a list of Entities using the given Criteria
     * @param crit
     * @return
     */
    public List<E> findCritList(Criteria crit);
}
