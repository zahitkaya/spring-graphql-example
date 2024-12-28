package com.spring.graphql.controller;

import com.spring.graphql.data.Order;
import com.spring.graphql.data.OrderRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryMapping
    public List<Order> order() {
        return orderRepository.findAll();
    }
}
