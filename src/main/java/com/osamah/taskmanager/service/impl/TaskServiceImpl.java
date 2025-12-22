package com.osamah.taskmanager.service.impl;

import com.osamah.taskmanager.dto.TaskRequest;
import com.osamah.taskmanager.dto.TaskResponse;
import com.osamah.taskmanager.model.Task;
import com.osamah.taskmanager.model.User;
import com.osamah.taskmanager.repository.TaskRepository;
import com.osamah.taskmanager.repository.UserRepository;
import com.osamah.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private User getUser(String username)
    {
        return userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not Found"));
    }
    private TaskResponse mapToResponse (Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .build();
    }



    @Override
    public TaskResponse createTask(TaskRequest request, String username) {
        User user = getUser(username);
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .createdAT(LocalDateTime.now())
                .user(user)
                .build();
        return mapToResponse(taskRepository.save(task));
    }

    @Override
    public List<TaskResponse> getMyTasks(String username) {
        User user = getUser(username);

        return taskRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id, String username) {
        User user = getUser(username);
        Task task = taskRepository.findByIdAndUser(id, user) .orElseThrow(()-> new RuntimeException("Task not found"));
        return mapToResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request, String username) {
        User user = getUser(username);
        Task task = taskRepository.findByIdAndUser(id,user).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        return mapToResponse(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id, String username) {
        User user = getUser(username);
        Task task = taskRepository.findByIdAndUser(id,user).orElseThrow(()-> new RuntimeException("Task not found"));

        taskRepository.delete(task);
    }
}
