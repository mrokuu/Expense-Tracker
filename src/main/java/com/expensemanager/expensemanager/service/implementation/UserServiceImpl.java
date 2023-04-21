package com.expensemanager.expensemanager.service.implementation;

import com.expensemanager.expensemanager.dto.RegistrationDto;
import com.expensemanager.expensemanager.entity.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        userRepository.save(user);
    }
}
