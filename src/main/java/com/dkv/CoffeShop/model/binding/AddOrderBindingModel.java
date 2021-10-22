package com.dkv.CoffeShop.model.binding;

import com.dkv.CoffeShop.model.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class AddOrderBindingModel {
    @Length(min = 3, max = 20)
    @NotBlank
    private String name;
    @Positive
    @NotNull
    private Double price;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryNameEnum category;
    @NotBlank
    @Length(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public AddOrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public AddOrderBindingModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getorderTime() {
        return orderTime;
    }

    public AddOrderBindingModel setorderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public AddOrderBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
