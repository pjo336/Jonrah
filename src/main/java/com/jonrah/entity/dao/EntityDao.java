package com.jonrah.entity.dao;

import com.jonrah.entity.EntityInterface;
import org.hibernate.Criteria;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

/**
 * Every DAO Interface must extend this interface
 */
public interface EntityDao<E extends EntityInterface> {

    /**
     * Create and return a Criteria object. Can be used in the service layer to create custom criteria queries
     * @return
     */
    public Criteria createCrit(EntityInterface clazz);

    /**
     * Add the entity to the database
     * @param entity in database
     */
    public void add(EntityInterface entity);

    /**
     * Update the entity with the new value
     * @param entity in database
     */
    public void update(EntityInterface entity);

    /**
     * Remove the entity
     * @param entity in database
     */
    public void remove(EntityInterface entity);

    /**
     * Find a list of Entities using the given Criteria
     * @param crit
     * @return
     */
    public List<E> findCritList(Criteria crit);
}
