package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.Model.OrderModel;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/orders")
    public class OrderController {

        @Autowired
        private OrderService service;

        @PostMapping
        public ResponseEntity<OrderModel> create(@RequestBody OrderModel order) {
            return ResponseEntity.ok(service.createOrder(order));
        }
    }


