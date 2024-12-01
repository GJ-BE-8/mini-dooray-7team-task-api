package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.dto.GetProject;
import com.nhnacademy.minidooray.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    GetProject getProjectByProjectId(Long id);
}
