package com.heady.todayapp.controller;

import com.heady.todayapp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editTask")
public class editTaskController {


    @GetMapping("/{id}")
    public String display(@PathVariable String id, Model model) {
        Task task = new Task("111", "My Task", "03:00PM", "01/22/22", "Walk the dog");
        model.addAttribute("messageEditTask", "Edit Task");
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/doEdit")
    public String doTask(Task task, Model model) {
        return "redirect:/index/";
    }
}
