package com.capgemini.moviemgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgmt.dao.MovieDao;
import com.capgemini.moviemgmt.model.Movie;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is an implementation of service class methods                                   
                                        
  *         Created Date    11-May-2020
 ****************************/

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao dao ;
	
	/****************************
	 *    Method        getAllMovies
     *    Description   To implement the method to fetch all the Movies
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@Override
	public List<Movie> getAllMovies(String movieName) {
		List<Movie> movies = dao.findAll() ;
		return movies;
	}
	
	
	/****************************
	 *    Method        searchMovie
     *    Description   To implement the method to fetch a Movie by it's name
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@Override
	public List<Movie> searchMovie(String movieName) {
		return dao.findByMovieName(movieName) ;
	}

	
	/****************************
	 *    Method        findMovieById
     *    Description   To implement the method to fetch a Movie by it's Id
     *    Created By    Priyavrat Sharma
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@Override
	public Movie findMovieById(int movieId) {
		Optional<Movie> m = dao.findById(movieId) ;
		if(!m.isPresent()) {
			return null ;
		}
		return m.get() ;
	}

}
