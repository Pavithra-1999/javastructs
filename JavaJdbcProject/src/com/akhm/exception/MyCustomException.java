package com.akhm.exception;

//here we are creating our own exception 
public class MyCustomException extends RuntimeException {

	public MyCustomException(String message) {
		super(message);
	}

}
