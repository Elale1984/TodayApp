package com.heady.todayapp.controller;

import com.heady.todayapp.model.RegisterUser;
import com.heady.todayapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/register")
public class Register {

    @GetMapping("/")
    public String display(Model model) {

        model.addAttribute("welcomeMessage", "Register");
        model.addAttribute("registerUser", new RegisterUser());

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(RegisterUser registerUser){

        return "redirect:/index/";
    }

}
