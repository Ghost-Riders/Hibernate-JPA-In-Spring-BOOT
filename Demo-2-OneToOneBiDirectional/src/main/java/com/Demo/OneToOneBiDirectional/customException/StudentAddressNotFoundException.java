package com.Demo.OneToOneBiDirectional.customException;

public class StudentAddressNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentAddressNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StudentAddressNotFoundException(String arg0) {
		super(arg0);
	}

	public StudentAddressNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
