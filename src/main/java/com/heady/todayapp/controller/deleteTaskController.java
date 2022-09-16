package com.heady.todayapp.controller;

import com.heady.todayapp.business.TaskBusinessServiceInterface;
import com.heady.todayapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteTask")
public class deleteTaskController {

    @Autowired
    TaskBusinessServiceInterface service;

    @GetMapping("/{id}")
    public String display(@PathVariable int id, Model model){
        service.deleteTask(id);
        return "redirect:/index/";
    }


}
