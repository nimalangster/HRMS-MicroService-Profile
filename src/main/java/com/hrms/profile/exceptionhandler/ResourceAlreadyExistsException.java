package com.hrms.profile.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {

	public ResourceAlreadyExistsException(Integer id,String resourceName) {
		super("Resource '" + resourceName +"' already exists with id " + id);
	}

	
}
