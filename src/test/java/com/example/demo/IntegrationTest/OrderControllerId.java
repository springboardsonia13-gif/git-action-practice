package com.example.demo.IntegrationTest;

import com.example.demo.Model.OrderModel;
import com.example.demo.repository.OrderRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OrderControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepo repository;

    @Test
    void shouldCreateOrderAndPersistToDatabase() throws Exception {

        OrderModel order = new OrderModel("Laptop", 2, 50000);
        MvcResult result = mockMvc.perform(post("/orders")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status().isOk())
                .andReturn();   // capture the result

        assertEquals(1, repository.count());
    }
}