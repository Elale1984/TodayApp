package com.heady.todayapp.repository;

import com.heady.todayapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private static final String INSERT_TASK_QUERY = "INSERT INTO task(id, title, starttime, date, details) VALUES (?,?,?,?,?)";
    private static final String GET_TASK_BY_ID = "SELECT * FROM task WHERE id=?";
    private static final String GET_ALL_TASKS = "SELECT * FROM task";
    private static final String EDIT_TASK_BY_ID = "UPDATE task SET title=?, starttime=?, date=?, details=? WHERE id=?";
    private static final String DELETE_TASK_BY_ID = "DELETE FROM task WHERE id=?";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTask(Task task) {
        jdbcTemplate.update(INSERT_TASK_QUERY, task.getId(), task.getTitle(), task.getStarttime(),
                task.getDate(), task.getDetails());
    }

    @Override
    public void deleteTask(String id) {
        jdbcTemplate.update(DELETE_TASK_BY_ID, id);
    }

    @Override
    public void editTask(Task task) {
        jdbcTemplate.update(EDIT_TASK_BY_ID, task.getId(), task.getTitle(), task.getStarttime(),
                task.getDetails(), task.getDetails());
    }

    @Override
    public Task getTaskById(String id) {
        return jdbcTemplate.queryForObject(GET_TASK_BY_ID, (rs, rowNum) -> new Task(
            rs.getString("id"),
            rs.getString("title"),
            rs.getString("starttime"),
            rs.getString("date"),
            rs.getString("details")
        ), id);
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query(GET_ALL_TASKS, (rs, rowNum) -> new Task(
            rs.getString("id"),
            rs.getString("title"),
            rs.getString("starttime"),
            rs.getString("date"),
            rs.getString("details")
        ));
    }
}
