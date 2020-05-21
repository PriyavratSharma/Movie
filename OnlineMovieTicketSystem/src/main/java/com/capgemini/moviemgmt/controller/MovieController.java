package com.capgemini.moviemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgmt.model.Movie;
import com.capgemini.moviemgmt.service.MovieService;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a controller class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Created Date     14-MAY-2020
 ****************************/
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service ;
	
	
	/****************************
	 *    Method        searchMovieByName
     *    Description   Method to search a movie by it's name
     *    Created By    Priyavrat Sharma
     *    Created Date  14-MAY-2020                       
	 ****************************/
	@RequestMapping(value = "/searchMovie/{movieName}")
	public ResponseEntity<List<Movie>> searchMovieByName(@PathVariable("movieName") String movieName){
		return new ResponseEntity<List<Movie>>(service.searchMovie(movieName), HttpStatus.OK) ;
	}
}
