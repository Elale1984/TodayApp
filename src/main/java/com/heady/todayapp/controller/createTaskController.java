package com.heady.todayapp.controller;

import com.heady.todayapp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createTask")
public class createTaskController {

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("messageCreateTask", "Create A Task");
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/doTask")
    public String doTask(Task task, Model model) {
        return "redirect:/index/";
    }

}
