package com.kindhope.web.exception;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
public class DAOException extends RuntimeException {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable ex) {
        super(message, ex);
    }
}
