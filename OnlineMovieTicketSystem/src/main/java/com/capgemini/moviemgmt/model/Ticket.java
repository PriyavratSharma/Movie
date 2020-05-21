package com.capgemini.moviemgmt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private boolean ticketStatus;

	public Ticket() {

	}

//	Parameterised Constructor
	public Ticket(int ticketId, boolean ticketStatus) {
		super();
		this.ticketId = ticketId;
		this.ticketStatus = ticketStatus;
	}

//	Getters and Setters
	public int getTicketId() {
		return ticketId;
	}

	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketStatus=" + ticketStatus + "]";
	}

	
}
