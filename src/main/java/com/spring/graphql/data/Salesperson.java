package com.spring.graphql.data;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SALESPEOPLE")
public class Salesperson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALESPERSON_ID")
    private Long id;

    @Column(name = "FIRST_NAME", length = 64, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 64, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 128, unique = true, nullable = false)
    private String email;

    @Column(name = "PHONE", length = 32)
    private String phone;

    @Column(name = "ADDRESS", length = 256)
    private String address;

    @Column(name = "CITY", length = 64)
    private String city;

    @Column(name = "STATE", length = 2)
    private String state;

    @Column(name = "ZIPCODE", length = 12)
    private String zipcode;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesperson that = (Salesperson) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    // toString
    @Override
    public String toString() {
        return "Salesperson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}