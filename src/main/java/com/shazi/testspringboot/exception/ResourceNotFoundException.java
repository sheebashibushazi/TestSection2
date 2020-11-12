package com.shazi.testspringboot.exception;

import java.io.Serializable;

import javassist.SerialVersionUID;

public class ResourceNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7721184373082725017L;

	public ResourceNotFoundException(String message) 
	{
		super(message);
		
	}
}
