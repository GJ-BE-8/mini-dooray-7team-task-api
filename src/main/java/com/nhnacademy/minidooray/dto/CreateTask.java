package com.nhnacademy.minidooray.dto;

import com.nhnacademy.minidooray.status.ProjectStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTask {
    private String taskName;
    private String taskContent;
}
