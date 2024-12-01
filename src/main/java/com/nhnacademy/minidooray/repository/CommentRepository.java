package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByTask_TaskId(Long taskId);
    List<Comment> findAllByUser_UserId(String userId);
}
