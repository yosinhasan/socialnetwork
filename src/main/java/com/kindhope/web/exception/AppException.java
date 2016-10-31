package com.kindhope.web.exception;

/**
 * @author Yosin_Hasan
 *
 */
public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1833951199006312533L;

	public AppException(String msg, Exception ex) {
		super(msg, ex);
	}

}
