package com.capgemini.moviemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgmt.model.Customer;
import com.capgemini.moviemgmt.model.Theater;
import com.capgemini.moviemgmt.service.CustomerService;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a controller class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Created Date     12-MAY-2020
 ****************************/

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService ;
	
	
	/****************************
	 *    Method        getCustomerDetails
     *    Description   Method to get Customer Details
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@GetMapping(value="/{customerId}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerId") int customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK) ;
	}
	
	
	/****************************
	 *    Method        updateCustomerDetails
     *    Description   Method to update the details of a customer
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@PutMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomerDetails(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomerDetails(customer), HttpStatus.OK) ;
	}
	
	
	
	/****************************
	 *    Method        getTheaterByCityName
     *    Description   Method to search  Theater by City name
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@GetMapping(value= "/chooseCity/{cityName}")
	public ResponseEntity<List<Theater>> getTheaterByCityName(@PathVariable("cityName") String cityName){
		return new ResponseEntity<List<Theater>>(customerService.getTheaterByCityName(cityName), HttpStatus.OK);
	}
	
	
	/****************************
	 *    Method        addBooking
     *    Description   Method to book a movie ticket
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@PostMapping(value= "/bookMovieTicket/{theaterId}")
	public ResponseEntity<String> addBooking(@PathVariable("theaterId") int theaterId){
//	Theater theater = customerService.findTheaterById(theaterId) ;
		return new ResponseEntity<String>("redirect:/booking", HttpStatus.OK);
	}
	
	
	/****************************
	 *    Method        cancelMovieTicket
     *    Description   Method to cancel a Movie Ticket
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@DeleteMapping("/cancelMovieTicket/{id}")
    public ResponseEntity<String> cancelMovieTicket(@PathVariable(value="id") int ticketId){
		return new ResponseEntity<String>(customerService.cancelMovieTicket(ticketId), HttpStatus.OK) ;
    }

}
