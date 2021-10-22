package com.dkv.CoffeShop.model;

import com.dkv.CoffeShop.model.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryNameEnum name;
    @Column(nullable = false)
    private Integer neededTime;

    public Category() {
    }

    public Category(CategoryNameEnum name, Integer neededTime) {
        this.name = name;
        this.neededTime = neededTime;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
