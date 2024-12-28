package com.spring.graphql.data;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID", length = 16, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerId;

    @Column(name = "SALESPERSON_ID")
    private Long salespersonId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(Long salespersonId) {
        this.salespersonId = salespersonId;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId=" + customerId +
                ", salespersonId=" + salespersonId +
                '}';
    }
}