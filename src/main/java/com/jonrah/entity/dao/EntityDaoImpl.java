package com.jonrah.entity.dao;

import com.jonrah.entity.EntityInterface;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class EntityDaoImpl implements EntityDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get the current session
     * @return
     */
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Criteria createCrit(EntityInterface clazz) {
        return sessionFactory.openSession().createCriteria(clazz.getClass());
    }

    @Override
    public void add(EntityInterface entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(EntityInterface entity) {
        currentSession().update(entity);
    }

    @Override
    public void remove(EntityInterface entity) {
        currentSession().delete(entity);
    }

    @Override
    public EntityInterface restoreById(long id) throws NotFoundException {
        return (EntityInterface) currentSession().get(this.getClass(), id);
    }

    @Override
    public List findCritList(Criteria crit) {
        return crit.list();
    }
}
