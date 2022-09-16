package com.heady.todayapp.repository;

import com.heady.todayapp.model.Task;

import java.util.List;

public interface TaskRepository {
    void createTask(Task task);
    void deleteTask(int id);
    void editTask(Task task);
    Task getTaskById(int id);
    List<Task> getAllTasks();
    int getNextTaskId();

}
