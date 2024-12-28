package com.spring.graphql.data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID", length = 32, nullable = false)
    private String id;

    @Column(name = "NAME", length = 128, nullable = false)
    private String name;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "VARIETY", length = 32)
    private String variety;

    @Column(name = "PRICE", precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "STATUS", length = 16)
    private String status;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", variety='" + variety + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}