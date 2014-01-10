package com.jonrah.entity.dao;

import com.jonrah.entity.JonrahEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

/**
 * Every concrete DAO must extend this class
 */
@Component
public class EntityDaoImpl<E extends JonrahEntity> implements EntityDao<E> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get the current session
     * @return the current session
     */
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Criteria createCrit(JonrahEntity clazz) {
        return currentSession().createCriteria(clazz.getClass());
    }

    @Override
    public void add(JonrahEntity entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(JonrahEntity entity) {
        currentSession().update(entity);
    }

    @Override
    public void remove(JonrahEntity entity) {
        currentSession().delete(entity);
    }

    @Override
    public List<E> findCritList(Criteria crit) {
        return (List<E>) crit.list();
    }
}
