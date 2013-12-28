package com.jonrah.genericdao;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by pjo336 on 12/17/13
 * biggertime
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    @Autowired
    private SessionFactory sessionFactory;
    protected Class<? extends E> daoType; // Class type

    /**
     * Set the class type being used as the entity
     */
    public GenericDaoImpl() {
        daoType = (Class<E>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    /**
     * Get the current session
     * @return
     */
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    // TODO create our own exceptions?
    @Override
    public E restore(K key) throws NotFoundException{
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public List<E> list() {
        return currentSession().createCriteria(daoType).list();
    }
}
