package com.osamah.taskmanager.dto;

import lombok.Getter;
import lombok.Builder;

@Getter
@Builder
public class TaskResponse {

    private Long id ;
    private String title;
    private String description;
    private boolean completed;

}
