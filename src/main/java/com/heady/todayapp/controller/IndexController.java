package com.heady.todayapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("message1", "Welcome Home");
        return "index";
    }

}
