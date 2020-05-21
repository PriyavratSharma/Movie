package com.capgemini.moviemgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgmt.model.Customer;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a Dao interface class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation
                                       
 *         Created Date    11-May-2020
 ****************************/
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}

