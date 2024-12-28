package com.spring.graphql.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.graphql.data.Customer;
import com.spring.graphql.data.CustomerRepository;
import com.spring.graphql.data.OrderLine;
import com.spring.graphql.data.OrderLineRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final OrderLineRepository orderLine;

    public CustomerController(CustomerRepository customerRepository, OrderLineRepository orderLine) {
        this.customerRepository = customerRepository;
        this.orderLine = orderLine;
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email) {
        return customerRepository.findByEmail(email);
    }

    @QueryMapping
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public List<OrderLine> orderLine() {
        return orderLine.findAll();
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name = "input") CustomerInput customerInput) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // CustomerInput -> Customer mapping
        Customer customer = objectMapper.convertValue(customerInput, Customer.class);

        return customerRepository.save(customer);
    }
}
