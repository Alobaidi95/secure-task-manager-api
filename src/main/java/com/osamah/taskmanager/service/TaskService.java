package com.osamah.taskmanager.service;

import com.osamah.taskmanager.dto.TaskResponse;
import com.osamah.taskmanager.dto.TaskRequest;
import java.util.List;

public interface TaskService {

    TaskResponse createTask (TaskRequest request );
    List<TaskResponse> getMyTasks ();
    TaskResponse getTaskById (Long id );
    TaskResponse updateTask (Long id, TaskRequest request);
    void deleteTask(Long id);
}
