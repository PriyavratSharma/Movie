package com.capgemini.moviemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgmt.model.Movie;
import com.capgemini.moviemgmt.service.TheaterService;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a controller class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Created Date     13-MAY-2020
 ****************************/
@RestController
@RequestMapping("/theater")
public class TheaterController {

	@Autowired
	private TheaterService service;
	
	
	/****************************
	 *    Method        getAllMovies
     *    Description   Method to fetch all movies
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@GetMapping(value = "/{theaterId}/allMovies")
	public ResponseEntity<List<Movie>> getAllMovies(@PathVariable("theaterId") int theaterId){
		return new ResponseEntity<List<Movie>>(service.getAllMovies(theaterId), HttpStatus.OK) ;
	}	
	
	
	/****************************
	 *    Method        getMovie
     *    Description   Method to fetch a movie using theaterId and movie name
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@GetMapping(value = "/{theaterId}/{movieName}")
	public ResponseEntity<Movie> getMovie(@PathVariable("movieName") String movieName, @PathVariable("theaterId") int theaterId){
	 	return new ResponseEntity<Movie>(service.getMovie(movieName, theaterId), HttpStatus.OK) ;
	}
}
