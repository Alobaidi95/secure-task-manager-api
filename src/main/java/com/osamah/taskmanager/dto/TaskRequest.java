package com.osamah.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    @NotBlank(message = "title is required")
    @Size (max = 100, message = "title must be at most 100 characters")
    private String title;

    @Size(max = 500 , message = "description should not exceed 500 characters")
    private String description;

    private Boolean completed;
}
