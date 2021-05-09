package com.Demo.OneToOneBiDirectional.customException;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StudentNotFoundException(String arg0) {
		super(arg0);
	}

	public StudentNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
