package com.heady.todayapp.controller;

import com.heady.todayapp.model.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("welcome", "Welcome to Today");
        model.addAttribute("actionLabel", "Login");
        model.addAttribute("loginData", new UserLogin());

        return "login";
    }

    @PostMapping ("/doLogin")
    public String doLogin(UserLogin userLogin){


        return "redirect:/index/";
    }

}
