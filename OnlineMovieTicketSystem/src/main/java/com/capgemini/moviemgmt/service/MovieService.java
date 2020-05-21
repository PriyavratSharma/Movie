package com.capgemini.moviemgmt.service;

import java.util.List;

import com.capgemini.moviemgmt.model.Movie;


/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a service class that provides the services for searching Movies 
                                      
                                        
 *          Created Date     11-May-2020
 ****************************/
public interface MovieService {
	
	/****************************
	 *    Method        findMovieById
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	public Movie findMovieById(int movieId) ;
	
	
	/****************************
	 *    Method        getAllMovies
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	public List<Movie> getAllMovies(String movieName) ;

	
	/****************************
	 *    Method        searchMovie
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	public List<Movie> searchMovie(String movieName);
}
