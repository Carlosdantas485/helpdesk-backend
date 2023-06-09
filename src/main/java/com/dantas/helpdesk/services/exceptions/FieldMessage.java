package com.dantas.helpdesk.services.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String FieldMessage;
	private String messge;

	public FieldMessage() {
		super();
	}

	public FieldMessage(String fieldMessage, String messge) {
		super();
		FieldMessage = fieldMessage;
		this.messge = messge;
	}

	public String getFieldMessage() {
		return FieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		FieldMessage = fieldMessage;
	}

	public String getMessge() {
		return messge;
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
	

}
