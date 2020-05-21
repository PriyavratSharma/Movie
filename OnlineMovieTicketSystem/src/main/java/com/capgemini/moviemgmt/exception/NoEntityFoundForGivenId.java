
package com.capgemini.moviemgmt.exception;


@SuppressWarnings("serial")
public class NoEntityFoundForGivenId extends RuntimeException{

	public NoEntityFoundForGivenId(String msg) {
		super(msg) ;
	}
}

