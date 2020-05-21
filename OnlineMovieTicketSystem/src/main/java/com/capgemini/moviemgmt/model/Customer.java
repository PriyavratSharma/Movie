package com.capgemini.moviemgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerPassword;
	private Date dateOfBirth;
	@OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ct_fk", referencedColumnName = "customerId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Ticket> myTickets;
	
	private String customerContact;
	
	public Customer() {
		
	}
	
	public Customer(int customerId, String customerName, String customerPassword, Date dateOfBirth,
			List<Ticket> myTickets, String customerContact) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.dateOfBirth = dateOfBirth;
		this.myTickets = myTickets;
		this.customerContact = customerContact;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Ticket> getMyTickets() {
		return myTickets;
	}
	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth + ", myTickets=" + myTickets + ", customerContact=" + customerContact + "]";
	}
	
}