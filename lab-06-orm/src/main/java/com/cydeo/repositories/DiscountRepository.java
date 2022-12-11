package com.cydeo.repositories;


import com.cydeo.entity.Discount;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    //Write a derived query to get discount by name


    //Write a derived query to get all discounts greater than discount amount


    //Write a derived query to get all discounts by specific discount type


    //Write a JPQL query to get all discounts amount between range of discount amount

    //03:10 :)
}