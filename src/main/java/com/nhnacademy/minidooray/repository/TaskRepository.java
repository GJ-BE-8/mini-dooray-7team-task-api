package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.dto.GetTask;
import com.nhnacademy.minidooray.entity.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    GetTask getTaskByTaskId(Long taskId);
}
