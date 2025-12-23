package com.osamah.taskmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    private String title;
    private String description;
    private Boolean completed;
}
