package com.nhnacademy.minidooray;

import com.nhnacademy.minidooray.controller.ProjectController;
import com.nhnacademy.minidooray.entity.Project;
import com.nhnacademy.minidooray.entity.Task;
import com.nhnacademy.minidooray.repository.ProjectRepository;
import com.nhnacademy.minidooray.repository.TaskRepository;
import com.nhnacademy.minidooray.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.nhnacademy.minidooray.status.ProjectStatus.ACTIVE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class MiniDoorayApplicationTests {

//    private MockMvc mockMvc;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setup() {
//        // MockMvc 초기화
//        mockMvc = MockMvcBuilders.standaloneSetup(new ProjectController(projectRepository, taskRepository)).build();
//    }
//
//    @Test
//    public void testCreateProject() throws Exception {
//        // 새 프로젝트 생성
//        Project project = new Project("Test Project", ACTIVE);
//        projectRepository.save(project);
//
//        // 프로젝트가 저장되었는지 확인
//        assert projectRepository.findById(project.getProjectId()).isPresent();
//    }
//
//    @Test
//    public void testCreateTask() throws Exception {
//        // 새 프로젝트 생성
//        Project project = new Project("Test Project", ACTIVE);
//        projectRepository.save(project);
//
//        // 새 작업 생성
//        Task task = new Task("Test Task", "This is a test task");
//        task.setProject(project);
//        taskRepository.save(task);
//
//        // 작업이 저장되었는지 확인
//        assert taskRepository.findById(task.getTaskId()).isPresent();
//    }
//
//    @Test
//    public void testCreateProjectViaApi() throws Exception {
//        // API를 통해 프로젝트 생성 테스트 (MockMvc 사용)
//        mockMvc.perform(post("/projects/register")
//                        .contentType("application/json")
//                        .content("{\"projectName\": \"API Project\", \"projectStatus\": \"ACTIVE\"}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testCreateTaskViaApi() throws Exception {
//        // 프로젝트 생성 후, 작업 생성 테스트 (MockMvc 사용)
//        mockMvc.perform(post("/projects/1/tasks")
//                        .contentType("application/json")
//                        .content("{\"taskName\": \"Test Task\", \"taskContent\": \"This is a test task\"}"))
//                .andExpect(status().isOk());
//    }
}
