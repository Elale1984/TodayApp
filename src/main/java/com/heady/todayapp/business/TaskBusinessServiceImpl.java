package com.heady.todayapp.business;


import com.heady.todayapp.model.Task;
import com.heady.todayapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskBusinessServiceImpl implements TaskBusinessServiceInterface {

    @Autowired
    private TaskRepository service;

    @Override
    public void createTask(Task task) {
        service.createTask(task);
    }

    @Override
    public void updateTask(Task task) {
        service.editTask(task);
    }

    @Override
    public Task readTask(String id) {
        return service.getTaskById(id);
    }

    @Override
    public void deleteTask(String id) {
        service.deleteTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }
}
