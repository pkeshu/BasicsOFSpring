package com.keshar.restwebservices.basicsofREST;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
