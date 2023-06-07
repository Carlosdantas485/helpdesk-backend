package com.dantas.helpdesk.domain;


import java.time.LocalDate;
import java.util.Objects;

import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity (name = "tb_called")
public class Called {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer  id;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		private LocalDate openData = LocalDate.now();
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		private LocalDate closeData = null;
		
		private Priority priority;
		private Status status;
		
		private String title;
		private String observation;
		
		@ManyToOne
		@JoinColumn(name = "tecnic_id")
		private Tecnic tecnic;
		
		@ManyToOne
		@JoinColumn(name = "client_id")
		private Client client;
		
		public Called() {
			super();
		}

		public Called(Integer id, Priority priority, Status status, String title, String observation, Tecnic tecnic,
				Client client) {
			super();
			this.id = id;
			this.priority = priority;
			this.status = status;
			this.title = title;
			this.observation = observation;
			this.tecnic = tecnic;
			this.client = client;
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

		public Priority getPriority() {
			return priority;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
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

		public Tecnic getTecnic() {
			return tecnic;
		}

		public void setTecnic(Tecnic tecnic) {
			this.tecnic = tecnic;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Called other = (Called) obj;
			return Objects.equals(id, other.id);
		}
		
		

		
		
		
		
		
		
}
