package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.dto.RegistrationDto;
import com.expensemanager.expensemanager.entity.User;
import com.expensemanager.expensemanager.service.UserService;
import com.expensemanager.expensemanager.service.implementation.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping({"/login", "/"})
    public String loginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/expenses";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationDto());
        return "register";
    }

    @PostMapping ("/register")
    public String register(@Valid @ModelAttribute("user") RegistrationDto registrationDto,
                           BindingResult bindingResult,
                           Model model ){
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.saveUser(registrationDto);
        model.addAttribute("successMsg", true);
        return "redirect:/login";
    }





}
