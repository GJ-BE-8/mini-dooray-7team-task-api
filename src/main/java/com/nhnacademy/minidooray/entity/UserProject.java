package com.nhnacademy.minidooray.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userproject_id")
    private long userProjectId;

    @Getter
    @ManyToOne
    private User user;

    @Getter
    @ManyToOne
    private Project project;

    public UserProject(User user, Project project) {
        this.user = user;
        this.project = project;
    }
}
