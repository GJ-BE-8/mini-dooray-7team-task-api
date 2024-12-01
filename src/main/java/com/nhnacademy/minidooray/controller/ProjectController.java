package com.nhnacademy.minidooray.controller;

import com.nhnacademy.minidooray.dto.CreateTask;
import com.nhnacademy.minidooray.dto.GetTask;
import com.nhnacademy.minidooray.entity.Project;
import com.nhnacademy.minidooray.entity.Task;
//import com.nhnacademy.minidooray.feignclient.TaskApiClient;
import com.nhnacademy.minidooray.repository.ProjectRepository;
import com.nhnacademy.minidooray.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    //프로젝트에 등록된 작업 조회
    @GetMapping("/{project_id}/tasks")
    public List<GetTask> getProject(@PathVariable Long project_id) {
        Project project = projectRepository.findById(project_id).orElse(null);
        List<Task> tasks = project.getTasks();
        List<GetTask> getTasks = new ArrayList<>();

        for (Task task : tasks) {
            long taskId = task.getTaskId();
            getTasks.add(taskRepository.getTaskByTaskId(taskId));
        }

        return getTasks;
    }

    //프로젝트에 작업 등록
    @PostMapping("/{project_id}/tasks")
    public Task createTask(@PathVariable long project_id, @RequestBody CreateTask createTask) {
        Project project = projectRepository.findById(project_id).orElse(null);
        Task task = new Task(createTask.getTaskName(), createTask.getTaskContent());

        List<Task> tasks = project.getTasks();
        List<GetTask> getTasks = new ArrayList<>();

        project.addTask(task);
        projectRepository.save(project);

        return task;
    }

    //프로젝트에 속한 작업 삭제
    @DeleteMapping("/{project_id}/tasks/{task_id}")
    public void deleteTask(@PathVariable long project_id, @PathVariable long task_id) {
        Task task = taskRepository.findById(task_id).orElse(null);
        Project project = projectRepository.findById(project_id).orElse(null);

        project.getTasks().remove(task);
        projectRepository.save(project);

    }

    //프로젝트에 대한 작업 업데이트
    @PatchMapping("/{project_id}/tasks/{task_id}")
    public GetTask updateProject(@PathVariable("project_id") long projectId, @PathVariable long task_id,
                                 @RequestBody CreateTask createTask) {
        Project project = projectRepository.findById(projectId).orElse(null);
        List<Task> tasks = project.getTasks();
        List<GetTask> getTasks = new ArrayList<>();
        for (Task task : project.getTasks()) {
            if (task.getTaskId() == task_id) {
                task.setTaskName(createTask.getTaskName());
                task.setTaskContent(createTask.getTaskContent());
            }
        }
        projectRepository.save(project);
        return taskRepository.getTaskByTaskId(task_id);
    }

}
