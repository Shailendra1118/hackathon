package com.morgan.asked;

public class MyException extends RuntimeException {
	String cause;
	public MyException(String cause){
		this.cause = cause;
	}
	
	
}
