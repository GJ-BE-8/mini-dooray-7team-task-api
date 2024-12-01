package com.nhnacademy.minidooray.dto;

import com.nhnacademy.minidooray.status.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProject {
    private String projectName;
    private ProjectStatus projectStatus;
}
