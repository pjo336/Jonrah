package com.pjo.jonrah.exceptions;


/**
 * @author Peter Johnston
 * @since November 22, 2015
 */
public class LogicException extends Exception implements JonrahException {

    public LogicException() {}

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
