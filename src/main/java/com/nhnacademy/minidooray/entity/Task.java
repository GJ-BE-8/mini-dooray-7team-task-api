package com.nhnacademy.minidooray.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @Column(name = "task_name", nullable = false, length = 50)
    private String taskName;

    @Column(name = "task_content", nullable = false, length = 500)
    private String taskContent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne(mappedBy = "task", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, orphanRemoval = true)
    private MileStone milestone;

    @OneToMany(mappedBy = "task", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, orphanRemoval = true)
    private List<Tag> tags;

    @OneToMany(mappedBy = "task", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, orphanRemoval = true)
    private List<Comment> comments;

    public Task(String taskName, String taskContent) {
        this.taskName = taskName;
        this.taskContent = taskContent;
    }

    public void addMilestone(MileStone milestone) {
        milestone.setTask(this);
        this.milestone = milestone;
    }

    public void addTag(Tag tag) {
        tag.setTask(this);
        tags.add(tag);
    }

    public void addComment(Comment comment) {
        comment.setTask(this);
        comments.add(comment);
    }
}
