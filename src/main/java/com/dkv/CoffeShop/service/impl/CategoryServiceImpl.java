package com.dkv.CoffeShop.service.impl;

import com.dkv.CoffeShop.model.Category;
import com.dkv.CoffeShop.model.enums.CategoryNameEnum;
import com.dkv.CoffeShop.repository.CategoryRepository;
import com.dkv.CoffeShop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize() {
        if(categoryRepository.count() == 0){
            Category coffee =
                    new Category()
                            .setName(CategoryNameEnum.Coffee)
                            .setNeededTime(2);
            Category cake =
                    new Category()
                            .setName(CategoryNameEnum.Cake)
                            .setNeededTime(15);
            Category drink =
                    new Category()
                            .setName(CategoryNameEnum.Drink)
                            .setNeededTime(1);
            Category other =
                    new Category()
                            .setName(CategoryNameEnum.Other)
                            .setNeededTime(5);

            categoryRepository.saveAllAndFlush(List.of(coffee, cake, drink, other));
        }
    }
}
