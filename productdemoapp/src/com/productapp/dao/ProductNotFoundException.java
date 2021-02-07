package com.productapp.dao;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
		
	}
	

}
