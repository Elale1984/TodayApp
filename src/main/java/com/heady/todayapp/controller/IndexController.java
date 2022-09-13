package com.heady.todayapp.controller;

import com.heady.todayapp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    List<Task> userTasks = new ArrayList<>();
    Task task1 = new Task("111", "The Test Task", "1:30 PM", "3/3/23", "Go To the doctor and find out if I am still living. Then I had to leave because it was weird  and find out if I am still living. Then I had to leave because i");
    Task task2 = new Task("112", "The Test Task 2", "11:30 PM", "3/3/23", "Watch some tv");

    @GetMapping("/")
    public String display(Model model){
        userTasks.add(task1);
        userTasks.add(task2);
        model.addAttribute("message1", "Today's Agenda");
        model.addAttribute("userTasks", userTasks);
        return "index";
    }

    @PostMapping("/doDelete")
    public String doDelete(Task task) {
        return "redirect:/index/";
    }

}
