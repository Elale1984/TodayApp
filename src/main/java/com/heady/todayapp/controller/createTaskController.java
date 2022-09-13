package com.heady.todayapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createTask")
public class createTaskController {

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("messageCreateTask", "Create A Task");

        return "createTask";
    }


}
