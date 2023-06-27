package com.dantas.helpdesk.domain;


import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity (name = "tb_tiket")
public class Tiket {
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
		@JoinColumn(name = "user_id")
		private Employee employee;
		
		@ManyToOne
		@JoinColumn(name = "custumer_id")
		private Custumer custumer;
		
		public Tiket() {
			super();
		}

		public Tiket(Integer id, Priority priority, Status status, String title, String observation, Employee employee,
				Custumer custumer) {
			super();
			this.id = id;
			this.priority = priority;
			this.status = status;
			this.title = title;
			this.observation = observation;
			this.employee = employee;
			this.custumer = custumer;
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

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public Custumer getCustumer() {
			return custumer;
		}

		public void setCustumer(Custumer custumer) {
			this.custumer = custumer;
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
			Tiket other = (Tiket) obj;
			return Objects.equals(id, other.id);
		}
		
		

		
		
		
		
		
		
}
