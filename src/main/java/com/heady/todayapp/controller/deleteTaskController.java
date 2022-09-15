package com.heady.todayapp.controller;

import com.heady.todayapp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteTask")
public class deleteTaskController {

    @GetMapping("/{id}")
    public String display(@PathVariable String id, Model model){
        System.out.println("deleted task");
        return "redirect:/index/";
    }


}
