package com.config.exception;

/**
 * The ConfigException class.
 * @author pgvishnu
 *
 */
public class ConfigException extends Exception {

	/**
	 *  serial version id.
	 */
	private static final long serialVersionUID = -8325622206465499326L;

	
	/**
	 * 
	 * @param msg
	 */
	public ConfigException(String msg) {
		super(msg);
	}
	
	/**
	 * 
	 * @param msg
	 * @param t
	 */
	public ConfigException(String msg, Throwable t) {
		super(msg,t);
	}


}
