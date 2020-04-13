package com.nilesh.poc.laundry.exception;

public class LaundryException extends Exception {
	
	private static final long serialVersionUID = -8950422643472633442L;
	private String message;
	public LaundryException(String message)
	{
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
