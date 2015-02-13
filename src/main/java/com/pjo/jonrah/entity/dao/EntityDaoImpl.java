package com.pjo.jonrah.entity.dao;

import com.pjo.jonrah.entity.JonrahEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

/**
 * Every concrete DAO must extend this class
 */
@Repository
public class EntityDaoImpl<E extends JonrahEntity> implements EntityDao<E> {

    @PersistenceContext()
    protected EntityManager entityManager;

    @Override
    public Criteria createCrit(JonrahEntity clazz) {
        return entityManager.unwrap(Session.class).createCriteria(clazz.getClass());
    }

    @Override
    public void add(JonrahEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void saveOrUpdate(JonrahEntity entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(JonrahEntity entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<E> findCritList(Criteria crit) {
        return (List<E>) crit.list();
    }
}
