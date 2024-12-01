package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.entity.UserProject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProject, Long> {
    List<UserProject> findAllByUser_UserId(String userId);
}
