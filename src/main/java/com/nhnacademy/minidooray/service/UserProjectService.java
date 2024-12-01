package com.nhnacademy.minidooray.service;

import com.nhnacademy.minidooray.dto.GetProject;
import com.nhnacademy.minidooray.entity.UserProject;
import com.nhnacademy.minidooray.feignclient.TaskApiClient;
import com.nhnacademy.minidooray.repository.ProjectRepository;
import com.nhnacademy.minidooray.repository.UserProjectRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

////유저가 속한 프로젝트들 조회
//@GetMapping("/users/{user_id}/projects")
//public List<GetProject> getProject(@PathVariable String user_id) {
//
//    List<UserProject> userProjects = userProjectRepository.findAllByUser_UserId(user_id);
//    List<GetProject> getProjects = new ArrayList<>();
//
//    for (UserProject userproject : userProjects) {
//        long projectId = userproject.getProject().getProjectId();
//        GetProject getProject = projectRepository.getProjectByProjectId(projectId);
//        getProjects.add(getProject);
//    }
//
//    return getProjects;
//}

@Slf4j
@Service
public class UserProjectService {
    private TaskApiClient taskApiClient;

    private UserProjectRepository userProjectRepository;

    private ProjectRepository projectRepository;

    @Autowired
    public UserProjectService(TaskApiClient taskApiClient, UserProjectRepository userProjectRepository, ProjectRepository projectRepository) {
        this.taskApiClient = taskApiClient;
        this.userProjectRepository = userProjectRepository;
        this.projectRepository = projectRepository;
    }

    public List<GetProject> getProjectsByUserId(String userId) {
        List<UserProject> userProjects = userProjectRepository.findAllByUser_UserId(userId);
        List<GetProject> getProjects = new ArrayList<>();

        for (UserProject userproject : userProjects) {
            long projectId = userproject.getProject().getProjectId();
            GetProject getProject = projectRepository.getProjectByProjectId(projectId);
            getProjects.add(getProject);
        }

        return getProjects;
    }
}
