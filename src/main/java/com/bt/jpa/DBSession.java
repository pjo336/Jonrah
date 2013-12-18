package com.bt.jpa;

/**
 * User: Peter Johnston
 * Date: 12/16/13
 */
public interface DBSession {

    /**
     * Allows the ability to start a transaction
     */
    public void beginTransaction();

    /**
     * Allows the ability to abort a transaction without committing
     */
    public void abortTransaction();
}
