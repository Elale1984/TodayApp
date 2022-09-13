package com.heady.todayapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editTask")
public class editTaskController {

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("messageEditTask", "Edit Task");

        return "editTask";
    }
}
