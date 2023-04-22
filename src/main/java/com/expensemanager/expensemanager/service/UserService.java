package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.dto.RegistrationDto;
import com.expensemanager.expensemanager.entity.User;

public interface UserService {

    public void  saveUser(RegistrationDto registrationDto);
    public User getLoggedUser();
}
