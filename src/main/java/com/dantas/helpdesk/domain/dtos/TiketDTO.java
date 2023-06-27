package com.dantas.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.dantas.helpdesk.domain.Tiket;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TiketDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate openData = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closeData = null;
	
	@NotNull(message = "Field priority is required!")
	private Integer priority;
	
	@NotNull(message = "Field status is required!")
	private Integer status;
	
	@NotNull(message = "Field title is required!")
	private String title;
	
	@NotNull(message = "Field observation is required!")
	private String observation;
	
	@NotNull(message = "Field tecnic is required!")
	private Integer emplyee;
	
	@NotNull(message = "Field client is required!")
	private Integer custumer;
	
	private String emplyeeName;
	private String custumerName;
	public TiketDTO() {
		super();
	}
	public TiketDTO(Tiket obj) {
		super();
		this.id = obj.getId();
		this.openData = obj.getOpenData();
		this.closeData = obj.getCloseData();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.observation = obj.getObservation();
		this.emplyee = obj.getEmployee().getId();
		this.custumer = obj.getCustumer().getId();
		this.emplyeeName = obj.getEmployee().getName();
		this.custumerName = obj.getEmployee().getName();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getOpenData() {
		return openData;
	}
	public void setOpenData(LocalDate openData) {
		this.openData = openData;
	}
	public LocalDate getCloseData() {
		return closeData;
	}
	public void setCloseData(LocalDate closeData) {
		this.closeData = closeData;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Integer getEmployee() {
		return emplyee;
	}
	public void setEmployee(Integer emplyee) {
		this.emplyee = emplyee;
	}
	public Integer getCustumer() {
		return custumer;
	}
	public void setCustumer(Integer custumer) {
		this.custumer = custumer;
	}
	public String getEmployeeName() {
		return emplyeeName;
	}
	public void setEmployeeName(String emplyeeName) {
		this.emplyeeName = emplyeeName;
	}
	public String getCustumerName() {
		return custumerName;
	}
	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}
	
}
