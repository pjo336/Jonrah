package com.bt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class DBSession {
    
    @Autowired
    private SessionFactory factory;
    private static Session session;
    private static Transaction trans;
    
    public DBSession() {
        Configuration  configuration = new Configuration().configure("/resources/hibernate.cfg.xml");
        factory = configuration.configure().buildSessionFactory();
        session = factory.getCurrentSession();
        trans = session.getTransaction();
    }
    
    public void beginTransaction() {
        trans.begin();
    }
    
    public void abortTransaction() {
        trans.rollback();
    }

}
