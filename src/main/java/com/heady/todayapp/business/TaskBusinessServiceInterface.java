package com.heady.todayapp.business;

import com.heady.todayapp.model.Task;

import java.util.List;

public interface TaskBusinessServiceInterface {
    void createTask(Task task);
    void updateTask(Task task);
    Task readTask(String id);
    void deleteTask(String id);
    List<Task> getAllTasks();


}
