package com.lhakpa.ecommerce.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    private Collection<CustomerOrder> customerOrder;

    public Collection<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Collection<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }
}
