package com.heady.todayapp.controller;

import com.heady.todayapp.business.UserBusinessServiceInterface;
import com.heady.todayapp.model.Task;
import com.heady.todayapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserBusinessServiceInterface userBusinessServiceInterface;
//    Logger factory
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("welcomeMessage", "Login");
        model.addAttribute("loginData", new User());

        return "login";
    }
    @GetMapping("/error")
    public String failLogin(User user, Model model) {
        model.addAttribute("welcomeMessage", "Login Failed");
        model.addAttribute("loginData", new User());
        return "login";
    }
    @PostMapping("/doLogin")
    public String doLogin(User user, Model model) {
        logger.info("Entering doLogin()");
        if(userBusinessServiceInterface.authenticateUser(user.getUsername(), user.getPassword()))
            return "redirect:/index/";
        else
            return "redirect:/login/error";
    }

}
