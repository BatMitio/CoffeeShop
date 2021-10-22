package com.dkv.CoffeShop.web;

import com.dkv.CoffeShop.model.binding.AddOrderBindingModel;
import com.dkv.CoffeShop.model.enums.CategoryNameEnum;
import com.dkv.CoffeShop.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AddOrderController {
    private final CurrentUser currentUser;

    public AddOrderController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/offers/add")
    public String getAddOrderPage(){
        return "order-add";
    }

    @ModelAttribute("categories")
    public CategoryNameEnum[] getCategories(){
        return CategoryNameEnum.values();
    }

    @ModelAttribute("bindingModel")
    public AddOrderBindingModel getBindingModel(){
        return new AddOrderBindingModel();
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOrderBindingModel bindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(!currentUser.isLoggedIn()){
            return "redirect:/";
        }
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("bindingModel", bindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
            return "redirect:/offers/add";
        }
        return "redirect:/";
    }
}
