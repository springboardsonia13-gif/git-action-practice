package com.example.demo.repository;


import com.example.demo.Model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderModel, Long> {
    }


