package com.nhnacademy.minidooray.dto;

import com.nhnacademy.minidooray.status.ProjectStatus;

public interface GetProject {
     long getProjectId();
     String getProjectName();
     ProjectStatus getProjectStatus();
}