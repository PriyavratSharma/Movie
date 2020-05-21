package com.capgemini.moviemgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional ;

import com.capgemini.moviemgmt.dao.TheaterDao;
import com.capgemini.moviemgmt.exception.NoEntityFoundForGivenId;
import com.capgemini.moviemgmt.exception.NoMovieFound;
import com.capgemini.moviemgmt.model.Movie;
import com.capgemini.moviemgmt.model.Theater;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is an implementation of service class methods                                   
                                        
  *         Created Date    12-May-2020
 ****************************/
@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private TheaterDao dao ;
	
	/****************************
	 *    Method        getMovie
     *    Description   To implement the method to fetch a Movie by it's name and theaterId
     *                  if theater is present,it will return the movie,else it will return an exception
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@Override
	public Movie getMovie(String movieName, int theaterId) {
		Optional<Theater> theater = dao.findById(theaterId) ;
		if(!theater.isPresent()) {
			throw new NoEntityFoundForGivenId("No theater Found!") ;
		}
		List<Movie> movies = theater.get().getMovies() ;
		for(Movie m : movies) {
			if(m.getMovieName().equals(movieName)) {
				return m ;
			}
		}
		throw new NoMovieFound("Oops " + movieName + "is not available!") ;
	}


	
	/****************************
	 *    Method        getAllMovies
     *    Description   To implement the method to fetch all the Movies by theater Id
     *    Created By    Priyavrat Sharma
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@Override
	public List<Movie> getAllMovies(int theaterId) {
		Optional<Theater> theater = dao.findById(theaterId);
		if(!theater.isPresent()) {
			throw new NoEntityFoundForGivenId("No theater Found for Given ID!") ;
		}
		return theater.get().getMovies() ;
	}
}
