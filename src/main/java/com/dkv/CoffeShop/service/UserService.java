package com.dkv.CoffeShop.service;

import com.dkv.CoffeShop.model.service.RegisterUserServiceModel;

public interface UserService {
    boolean emailIsFree(String value);

    boolean register(RegisterUserServiceModel serviceModel);

    boolean login(String username, String password);

    void logout();
}
