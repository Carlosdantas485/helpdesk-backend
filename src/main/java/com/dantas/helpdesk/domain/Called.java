package com.dantas.helpdesk.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Status;

public class Called {

		private Integer id;
		private LocalDate openDate = LocalDate.now();
		private LocalDate closeDate;
		
		private Priority priority;
		
		private Status status;
		
		private String title;
		private String observation;
		
		private Tecnic tecnic;
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

		public LocalDate getOpenDate() {
			return openDate;
		}

		public void setOpenDate(LocalDate openDate) {
			this.openDate = openDate;
		}

		public LocalDate getCloseDate() {
			return closeDate;
		}

		public void setCloseDate(LocalDate closeDate) {
			this.closeDate = closeDate;
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
