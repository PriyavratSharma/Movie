package com.capgemini.moviemgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgmt.model.Theater;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a Dao interface class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation
                                       
 *         Created Date    11-May-2020
 ****************************/
@Repository
public interface TheaterDao extends JpaRepository<Theater, Integer>{

	List<Theater> findByTheaterCity(String cityName) ;
		
}
