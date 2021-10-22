package com.dkv.CoffeShop.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Instant orderTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private User employee;

    public Order() {
    }

    public Order(String name, Double price, Instant orderTime, Category category, String description, User employee) {
        this.name = name;
        this.price = price;
        this.orderTime = orderTime;
        this.category = category;
        this.description = description;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Instant getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(Instant orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public Order setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
