package com.dantas.helpdesk.services.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.dantas.helpdesk.resources.exceptions.StandardError;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestemp, Integer status, String error, String message, String path) {
		super(timestemp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	

}
