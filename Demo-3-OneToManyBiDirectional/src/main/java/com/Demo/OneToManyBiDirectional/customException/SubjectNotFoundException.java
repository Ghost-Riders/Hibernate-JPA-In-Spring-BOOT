package com.Demo.OneToManyBiDirectional.customException;

public class SubjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubjectNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SubjectNotFoundException(String arg0) {
		super(arg0);
	}

	public SubjectNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
