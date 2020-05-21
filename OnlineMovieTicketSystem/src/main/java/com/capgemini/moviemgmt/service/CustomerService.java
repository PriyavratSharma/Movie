package com.capgemini.moviemgmt.service;

import java.util.List;

import com.capgemini.moviemgmt.model.Customer;
import com.capgemini.moviemgmt.model.Theater;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a service class that provides the services for searching Customer details, 
                              ,searching a theater,cancel booking ,etc          
                                        
 *          Created Date     11-May-2020
 ****************************/

public interface CustomerService {
	
	/****************************
	 *    Method        getCustomerById
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	public Customer getCustomerById(int customerId) ;
	
	/****************************
	 *    Method        UpdateCustomerDetails
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	
	public Customer updateCustomerDetails(Customer customer) ;
	
	/****************************
	 *    Method        findTheaterById
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/

	public Theater findTheaterById(int theaterId) ;
	
	/****************************
	 *    Method        getTheaterByCityName
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	
	public List<Theater> getTheaterByCityName(String cityName) ;
	
	/****************************
	 *    Method        CancelMovieTicket
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  11-MAY-2020                       
	 ****************************/
	
	public String cancelMovieTicket(int ticketId) ;
	
}
