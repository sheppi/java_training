package com.epam.pool.dao.exception;

/**
 * Created by Kirill_Kaluga on 7/13/2016.
 */
public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
