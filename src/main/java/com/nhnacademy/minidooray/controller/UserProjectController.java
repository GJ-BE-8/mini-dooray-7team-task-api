package com.nhnacademy.minidooray.controller;

import com.nhnacademy.minidooray.auth.Auth;
import com.nhnacademy.minidooray.dto.GetProject;
import com.nhnacademy.minidooray.dto.CreateProject;
import com.nhnacademy.minidooray.entity.Project;
import com.nhnacademy.minidooray.entity.User;
import com.nhnacademy.minidooray.entity.UserProject;
//import com.nhnacademy.minidooray.feignclient.TaskApiClient;
import com.nhnacademy.minidooray.feignclient.TaskApiClient;
import com.nhnacademy.minidooray.repository.ProjectRepository;
import com.nhnacademy.minidooray.repository.TaskRepository;
import com.nhnacademy.minidooray.repository.UserProjectRepository;
import com.nhnacademy.minidooray.repository.UserRepository;
import com.nhnacademy.minidooray.service.UserProjectService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProjectRepository userProjectRepository;

    @Autowired
    private UserProjectService userProjectService;

    //유저가 속한 프로젝트들 조회
//    @GetMapping("/users/{user_id}/projects")
//    public List<GetProject> getProject(@PathVariable String user_id) {
//
//        List<UserProject> userProjects = userProjectRepository.findAllByUser_UserId(user_id);
//        List<GetProject> getProjects = new ArrayList<>();
//
//        for (UserProject userproject : userProjects) {
//            long projectId = userproject.getProject().getProjectId();
//            GetProject getProject = projectRepository.getProjectByProjectId(projectId);
//            getProjects.add(getProject);
//        }
//
//        return getProjects;
//    }

    @GetMapping("/users/{user_id}/projects")
    public List<GetProject> getProject(@PathVariable String user_id) {
        return userProjectService.getProjectsByUserId(user_id);
    }


    //프로젝트 등록
    @PostMapping("/users/{user_id}/projects")
    public void createUserProject(@PathVariable String user_id, @RequestBody CreateProject createProject) {
        User user = userRepository.findById(user_id).orElse(null);

        if (Objects.nonNull(user)) {
            user.setAuth(Auth.PROJECT_ADMIN);
            userRepository.save(user);
        }

        Project project = new Project(createProject.getProjectName(), createProject.getProjectStatus());
        UserProject userProject = new UserProject(user, project);

        projectRepository.save(project);
        userProjectRepository.save(userProject);
    }
}
