package com.heady.todayapp.business;

import com.heady.todayapp.model.Task;

import java.util.List;

public interface TaskBusinessServiceInterface {
    void createTask(Task task);
    void updateTask(Task task);
    Task readTask(int id);
    void deleteTask(int id);
    List<Task> getAllTasks();
    int getNextTaskId();

}
