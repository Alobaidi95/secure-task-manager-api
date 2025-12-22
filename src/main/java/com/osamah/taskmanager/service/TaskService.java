package com.osamah.taskmanager.service;

import com.osamah.taskmanager.dto.TaskResponse;
import com.osamah.taskmanager.dto.TaskRequest;
import java.util.List;

public interface TaskService {

    TaskResponse createTask (TaskRequest request ,String username);
    List<TaskResponse> getMyTasks (String username);
    TaskResponse getTaskById (Long id , String username);
    TaskResponse updateTask (Long id, TaskRequest request, String username );
    void deleteTask(Long id, String username);
}
