package com.expensemanager.expensemanager.service.implementation;

import com.expensemanager.expensemanager.dto.RegistrationDto;
import com.expensemanager.expensemanager.entity.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setUserId(UUID.randomUUID().toString());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getLoggedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserEmail = authentication.getName();
        return         userRepository.findByEmail(loggedUserEmail).orElseThrow(()-> new UsernameNotFoundException("User not found"));

    }
}
