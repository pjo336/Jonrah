package com.bt.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBSession {
    
    @Autowired
    private SessionFactory factory;
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    private Transaction currentTransaction;

    public DBSession() {
    }

    public void beginTransaction() {
        currentTransaction = factory.getCurrentSession().beginTransaction();
    }

    public void abortTransaction() {
        if(currentTransaction != null) {
            currentTransaction.rollback();
        }
    }

}
