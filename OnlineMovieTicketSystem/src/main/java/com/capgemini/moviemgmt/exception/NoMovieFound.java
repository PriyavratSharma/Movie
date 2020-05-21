package com.capgemini.moviemgmt.exception;

@SuppressWarnings("serial")
public class NoMovieFound extends RuntimeException{

	public NoMovieFound(String msg) {
		super(msg) ;
	}
}

