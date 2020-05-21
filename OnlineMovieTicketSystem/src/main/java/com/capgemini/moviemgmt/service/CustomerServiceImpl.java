package com.capgemini.moviemgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgmt.dao.CustomerDao;
import com.capgemini.moviemgmt.dao.TheaterDao;
import com.capgemini.moviemgmt.dao.TicketDao;
import com.capgemini.moviemgmt.exception.NoEntityFoundForGivenId;
import com.capgemini.moviemgmt.model.Customer;
import com.capgemini.moviemgmt.model.Theater;
import com.capgemini.moviemgmt.model.Ticket;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is an implementation of service class methods                                   
                                        
  *         Created Date    11-May-2020
 ****************************/

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao ;
	
	@Autowired
	private TheaterDao theaterDao ;
	
	@Autowired
	private TicketDao ticketDao ;
	
	
	/****************************
	 *    Method        getCustomerById
     *    Description   To implement the method to fetch Customers by their Id's
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> cust = customerDao.findById(customerId) ;
		if(!cust.isPresent()) {
			throw new NoEntityFoundForGivenId("No Customer Found for given ID!") ;
		}
		return cust.get() ;
	}
	
	
	/****************************
	 *    Method        updateCustomerDetails
     *    Description   To implement the method to fupdate the details of Customers
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	@Override
	public Customer updateCustomerDetails(Customer customer) {
		Optional<Customer> cust = customerDao.findById(customer.getCustomerId()) ;
		if(!cust.isPresent()) {
			throw new NoEntityFoundForGivenId("No Customer Found!") ;
		}
		customerDao.save(customer) ;
		return customer ;
	}
	
	
	/****************************
	 *    Method        findTheaterById
     *    Description   To implement the method to fetch Theaters by their Id's
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	@Override
	public Theater findTheaterById(int theaterId) {
		Optional<Theater> t = theaterDao.findById(theaterId) ;
		if(!t.isPresent()) {
			return null ;
		}
		Theater theater = t.get() ;
		return theater ;
	}
	
	
	/****************************
	 *    Method        getTheaterByCityName
     *    Description   To implement the method to fetch Theaters by City names
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	@Override
	public List<Theater> getTheaterByCityName(String cityName) {
		return theaterDao.findByTheaterCity(cityName) ;
	}

	
	/****************************
	 *    Method        cancelMovieTicket
     *    Description   To implement the method to cancel the movie ticket
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	@Override
	public String cancelMovieTicket(int ticketId) {
		Optional<Ticket> ticket = ticketDao.findById(ticketId) ;
		if(!ticket.isPresent()) {
			throw new NoEntityFoundForGivenId("No Ticket Found for given ID!") ;
		}
		ticketDao.deleteById(ticketId);
		return "Ticket Cancelled Successfully!" ;
	}

}
