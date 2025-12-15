package com.example.demo.service;

import com.example.demo.Model.OrderModel;
import com.example.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

        @Autowired
        private OrderRepo repository;

        public OrderModel createOrder(OrderModel order) {
            if (order.getQuantity() <= 0) {
                throw new IllegalArgumentException("Invalid quantity");
            }
            return repository.save(order);
        }

        public double calculateTotal(double price, int quantity) {
            if (price <= 0 || quantity <= 0) {
                throw new IllegalArgumentException("Invalid input");
            }
            return price * quantity;
        }
    }


