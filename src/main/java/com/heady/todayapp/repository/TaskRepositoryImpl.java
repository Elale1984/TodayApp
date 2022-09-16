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

    private static final String GET_NEXT_TASK_ID_QUERY = "SELECT MAX(id) FROM task";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTask(Task task) {
        jdbcTemplate.update(INSERT_TASK_QUERY, task.getId(), task.getTitle(), task.getStarttime(),
                task.getDate(), task.getDetails());
    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK_BY_ID, id);
    }

    @Override
    public void editTask(Task task) {
        jdbcTemplate.update(EDIT_TASK_BY_ID, task.getTitle(), task.getStarttime(),
                task.getDate(), task.getDetails(), task.getId());
    }

    @Override
    public Task getTaskById(int id) {
        return jdbcTemplate.queryForObject(GET_TASK_BY_ID, (rs, rowNum) -> new Task(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("starttime"),
            rs.getString("date"),
            rs.getString("details")
        ), id);
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query(GET_ALL_TASKS, (rs, rowNum) -> new Task(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("starttime"),
            rs.getString("date"),
            rs.getString("details")
        ));
    }

    @Override
    public int getNextTaskId() {
        if(jdbcTemplate.queryForObject(GET_NEXT_TASK_ID_QUERY, Integer.class) == null)
            return 0;
        else
            return jdbcTemplate.queryForObject(GET_NEXT_TASK_ID_QUERY, Integer.class) + 1;
    }
}
