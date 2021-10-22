package com.dkv.CoffeShop.web;

import com.dkv.CoffeShop.model.binding.LoginUserBindingModel;
import com.dkv.CoffeShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String getLoginPage() {
        return "login";
    }

    @ModelAttribute(name = "wrongCredentials")
    public boolean initialsWrongCredentials() {
        return false;
    }

    @ModelAttribute("bindingModel")
    public LoginUserBindingModel getBindingModel() {
        return new LoginUserBindingModel();
    }

    @PostMapping("/users/login")
    public String loginUser(@Valid LoginUserBindingModel bindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            if (this.userService.login(bindingModel.getUsername(), bindingModel.getPassword())) {
                return "redirect:/";
            }
            redirectAttributes.addFlashAttribute("wrongCredentials", true);
        }
        redirectAttributes.addFlashAttribute("bindingModel", bindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
        return "redirect:/users/login";
    }
}
