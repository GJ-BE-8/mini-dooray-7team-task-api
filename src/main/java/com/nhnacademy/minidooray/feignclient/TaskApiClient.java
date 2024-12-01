package com.nhnacademy.minidooray.feignclient;

import com.nhnacademy.minidooray.dto.GetProject;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "taskApi", url = "http://localhost:8080")
public interface TaskApiClient {

    @GetMapping("/users/{user_id}/projects")
    List<GetProject> getProject(@PathVariable String user_id, @RequestBody List<GetProject> projects);
}
