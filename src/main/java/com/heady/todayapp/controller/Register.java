package com.heady.todayapp.controller;

import com.heady.todayapp.business.UserBusinessServiceInterface;
import com.heady.todayapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class Register {

    @Autowired
    private UserBusinessServiceInterface service;

    @GetMapping("/")
    public String display(Model model) {

        model.addAttribute("welcomeMessage", "Register");
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(User user){
        service.registerUser(user);
        return "redirect:/index/";
    }

}
