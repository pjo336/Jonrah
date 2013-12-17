package com.bt.hibernate;

/**
 * User: Peter Johnston
 * Date: 12/16/13
 */
public interface DBSession {

    public void beginTransaction();

    public void abortTransaction();
}
