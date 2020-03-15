package com.psl.junit.exception;

public class ItemException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ItemException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ItemException() {
		super();
	}
}
