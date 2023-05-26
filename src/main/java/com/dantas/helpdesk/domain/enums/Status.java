package com.dantas.helpdesk.domain.enums;

public enum Status {
	OPENED(0, "ROLE_OPENED"), INPROGRESS(1, "ROLE_INPROGRESS"), CLOSED(2, "ROLE_TRECNIC");
	
	private Integer code;
	private String description;
	
	private Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid status");
	}
}
