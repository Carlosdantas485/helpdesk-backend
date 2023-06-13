package com.dantas.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.dantas.helpdesk.domain.Called;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class CalledDTO implements Serializable{
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
	private Integer tecnic;
	
	@NotNull(message = "Field client is required!")
	private Integer client;
	
	private String tecnicName;
	private String clientName;
	public CalledDTO() {
		super();
	}
	public CalledDTO(Called obj) {
		super();
		this.id = obj.getId();
		this.openData = obj.getOpenData();
		this.closeData = obj.getCloseData();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.observation = obj.getObservation();
		this.tecnic = obj.getTecnic().getId();
		this.client = obj.getClient().getId();
		this.tecnicName = obj.getTecnic().getName();
		this.clientName = obj.getClient().getName();
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
	public Integer getTecnic() {
		return tecnic;
	}
	public void setTecnic(Integer tecnic) {
		this.tecnic = tecnic;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getTecnicName() {
		return tecnicName;
	}
	public void setTecnicName(String tecnicName) {
		this.tecnicName = tecnicName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
}
