package com.nhnacademy.minidooray.controller;

import com.nhnacademy.minidooray.dto.CreateComment;
import com.nhnacademy.minidooray.dto.CreateMileStone;
import com.nhnacademy.minidooray.dto.CreateTag;
import com.nhnacademy.minidooray.entity.*;
import com.nhnacademy.minidooray.repository.ProjectRepository;
import com.nhnacademy.minidooray.repository.TaskRepository;
import com.nhnacademy.minidooray.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    //작업에 마일스톤 등록
    @PostMapping("/{task_id}/milestone")
    public MileStone createMileStone(@PathVariable long task_id, @RequestBody CreateMileStone createMileStone) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        MileStone milestone = new MileStone(createMileStone.getMilestoneName());
        task.addMilestone(milestone);
        taskRepository.save(task);

        return milestone;
    }

    //작업에서 마일스톤 삭제
    @DeleteMapping("/{task_id}/milestone")
    public void deleteMileStone(@PathVariable long task_id) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setMilestone(null);
        taskRepository.save(task);
    }

    //작업에 태그 등록
    @PostMapping("/{task_id}/tag")
    public Tag createTag(@PathVariable long task_id, @RequestBody CreateTag createTag) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        Tag tag = new Tag(createTag.getTagName());
        task.addTag(tag);
        taskRepository.save(task);
        return tag;
    }

    //작업에서 태그 삭제
    @DeleteMapping("/{task_id}/tag/{tag_id}")
    public void deleteTag(@PathVariable long task_id, @PathVariable String tag_id) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.getTags().removeIf(tag -> tag.getTagId() == Long.parseLong(tag_id));
        taskRepository.save(task);
    }


    //작업에 comment 등록
    @PostMapping("/{task_id}/users/{user_id}/comments")
    public List<Comment> createComment(@PathVariable long task_id, @PathVariable String user_id, @RequestBody CreateComment createComment) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = new Comment(createComment.getCommentContent());

        task.addComment(comment);
        user.addComment(comment);

        taskRepository.save(task);
        userRepository.save(user);

        return task.getComments();
    }


    //작업에서 comment 수정
    @PatchMapping("/{task_id}/comments/{comment_id}")
    public Comment updateComment(@PathVariable long task_id, @PathVariable String comment_id, @RequestBody String updatedContent) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        Comment comment = task.getComments().stream()
                .filter(c -> c.getCommentId() == Long.parseLong(comment_id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        comment.setCommentContent(updatedContent);
        taskRepository.save(task);
        return comment;
    }

    //작업에서 comment 삭제
    @DeleteMapping("/{task_id}/comments/{comment_id}")
    public Project deleteComment(@PathVariable long task_id, @PathVariable String comment_id) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.getComments().removeIf(comment -> comment.getCommentId() == Long.parseLong(comment_id));
        taskRepository.save(task);
        return task.getProject();
    }
}