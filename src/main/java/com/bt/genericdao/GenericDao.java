package com.bt.genericdao;

import java.util.List;

/**
 * Created by pjo336 on 12/17/13
 * biggertime
 */
public interface GenericDao<E, K> {

    void add(E entity);
    void update(E entity);
    void remove(E entity);
    E find(K key);
    List<E> list();
}
