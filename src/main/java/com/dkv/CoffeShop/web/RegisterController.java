package com.dkv.CoffeShop.web;

import com.dkv.CoffeShop.model.binding.LoginUserBindingModel;
import com.dkv.CoffeShop.model.binding.RegisterUserBindingModel;
import com.dkv.CoffeShop.model.service.RegisterUserServiceModel;
import com.dkv.CoffeShop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users/register")
    public String getRegisterPage(Model model){
        return "register";
    }

    @ModelAttribute("bindingModel")
    public RegisterUserBindingModel registerUserBindingModel(){
        return new RegisterUserBindingModel();
    }

    @ModelAttribute("passwordsDontMatch")
    public boolean getPasswordsMatch(){
        return false;
    }

    @ModelAttribute("unsuccessfulRegistration")
    public boolean getUnsuccessfulRegistration(){
        return false;
    }



    @PostMapping("/users/register")
    public String registerUser(
            @Valid RegisterUserBindingModel bindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !bindingModel.getPassword().equals(bindingModel.getConfirmPassword())){
            if(!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())){
                redirectAttributes.addFlashAttribute("passwordsDontMatch", true);
            }
            redirectAttributes.addFlashAttribute("bindingModel", bindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
            return "redirect:/users/register";
        }
        RegisterUserServiceModel serviceModel =
                this.modelMapper.map(bindingModel, RegisterUserServiceModel.class);
        if(!this.userService.register(serviceModel)){
            redirectAttributes.addFlashAttribute("unsuccessfulRegistration", true);
            redirectAttributes.addFlashAttribute("bindingModel", bindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
            return "redirect:/users/register";
        }
        return "redirect:/";
    }
}
