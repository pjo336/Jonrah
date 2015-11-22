package com.pjo.jonrah.exceptions;

/**
 * @author Peter Johnston
 * @since November 22, 2015
 */
public class NotFoundException extends Exception implements JonrahException {

    public NotFoundException() {}

    public NotFoundException(String message) { super(message); }

    public NotFoundException(String message, Throwable throwable) { super(message, throwable); }
}
