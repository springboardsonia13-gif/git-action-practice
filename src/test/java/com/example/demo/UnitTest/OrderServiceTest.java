package com.example.demo.UnitTest;

import com.example.demo.service.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderServiceTest {

        private OrderService orderService = new OrderService();

        @Test
        void calculateTotal_success() {
            assertEquals(200, orderService.calculateTotal(100, 2));
        }

        @Test
        void calculateTotal_invalidInput() {
            assertThrows(IllegalArgumentException.class,
                    () -> orderService.calculateTotal(-1, 2));
        }
    }


