package com.dkv.CoffeShop.service.impl;

import com.dkv.CoffeShop.model.User;
import com.dkv.CoffeShop.model.service.RegisterUserServiceModel;
import com.dkv.CoffeShop.repository.UserRepository;
import com.dkv.CoffeShop.service.UserService;
import com.dkv.CoffeShop.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean emailIsFree(String value) {
        return !this.userRepository.existsByEmail(value);
    }

    @Override
    public boolean register(RegisterUserServiceModel serviceModel) {
        User user = new User()
                .setEmail(serviceModel.getEmail())
                .setFirstName(serviceModel.getFirstName())
                .setLastName(serviceModel.getLastName())
                .setUsername(serviceModel.getUsername())
                .setPassword(this.passwordEncoder.encode(serviceModel.getPassword()));
        if(!this.userRepository.existsByUsername(user.getUsername()) && !this.userRepository.existsByEmail(user.getEmail())){
            user = this.userRepository.saveAndFlush(user);
            login(user);
            return true;
        }
        return false;
    }

    private void login(User user) {
        this.currentUser
                .setLoggedIn(true)
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());
    }

    @Override
    public boolean login(String username, String password) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        if(user != null && this.passwordEncoder.matches(password, user.getPassword())){
            login(user);
            return true;
        }
        currentUser.clear();
        return false;
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }
}
