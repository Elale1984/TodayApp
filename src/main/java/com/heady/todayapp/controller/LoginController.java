package com.heady.todayapp.controller;

import com.heady.todayapp.model.Task;
import com.heady.todayapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("welcomeMessage", "Login");
        model.addAttribute("loginData", new User());

        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(User user) {
        return "redirect:/index/";
    }

}
