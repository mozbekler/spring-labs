package com.cydeo.repositories;

import com.cydeo.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,String> {

    //Write a derived query to get all address with a specific customer


    //Write a derived query to get address with a specific street


    //Write a derived query to get top 3 address with a specific customer email


    //Write a derived query to get all address with a specific customer and name


    //Write a derived query to list all address where the beginning of the street contains the keyword


    //Write a JPQL query to get all address with a specific customerId

}