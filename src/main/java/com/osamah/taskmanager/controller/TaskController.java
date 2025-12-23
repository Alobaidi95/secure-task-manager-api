package com.osamah.taskmanager.controller;

import com.osamah.taskmanager.dto.TaskRequest;
import com.osamah.taskmanager.dto.TaskResponse;
import com.osamah.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                taskService.createTask(request, authentication.getName())
        );
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getMyTasks(
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                taskService.getMyTasks(authentication.getName())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(
            @PathVariable Long id,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                taskService.getTaskById(id, authentication.getName())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                taskService.updateTask(id, request, authentication.getName())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(
            @PathVariable Long id,
            Authentication authentication
    ) {
        taskService.deleteTask(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }
}
