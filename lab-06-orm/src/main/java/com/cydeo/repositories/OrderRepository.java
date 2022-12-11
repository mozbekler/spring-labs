package com.cydeo.repositories;

import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPrice();

    //Write a derived query to get all orders by customer email
    List<Order> findAllByCustomer_Email(String email);

    //Write a derived query to get all orders by specific payment method
    List<Order> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod);



    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomer_Email(String email);

    //Write a native query to get all orders by specific product name
    //@Query(value ="SELECT * FROM orders " ,nativeQuery = true)
    //Write a native query to get all orders by specific categoryId
    //Write a derived query to get all orders by totalPrice and paidPrice are equals
    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null

}