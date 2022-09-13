package com.heady.todayapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteTask")
public class deleteTaskController {

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("messageDeleteTask", "Delete Task");

        return "deleteTask";
    }
}
