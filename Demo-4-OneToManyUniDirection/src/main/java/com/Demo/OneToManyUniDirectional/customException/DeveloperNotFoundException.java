package com.Demo.OneToManyUniDirectional.customException;

public class DeveloperNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeveloperNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DeveloperNotFoundException(String arg0) {
		super(arg0);
	}

	public DeveloperNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
