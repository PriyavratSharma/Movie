package com.capgemini.moviemgmt.service;

import java.util.List;

import com.capgemini.moviemgmt.model.Movie;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a service class that provides the services for searching movie by Theaters
                                      
                                        
 *          Created Date     12-May-2020
 ****************************/
public interface TheaterService {
	
	/****************************
	 *    Method        getAllMovies
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	public List<Movie> getAllMovies(int theaterId) ;
	
	
	/****************************
	 *    Method        getMovie
     *    Description   define the method
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	public Movie getMovie(String movieName, int TheaterId) ;
	
}
