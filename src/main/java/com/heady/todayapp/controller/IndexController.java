package com.heady.todayapp.controller;

import com.heady.todayapp.business.TaskBusinessServiceInterface;
import com.heady.todayapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TaskBusinessServiceInterface service;



    @GetMapping("/")
    public String display(Model model){
        List<Task> allTasks = service.getAllTasks();
        model.addAttribute("message1", "Today's Agenda");
        model.addAttribute("userTasks", allTasks);
        return "index";
    }

    @PostMapping("/doDelete")
    public String doDelete(Task task) {
        return "redirect:/index/";
    }

}
