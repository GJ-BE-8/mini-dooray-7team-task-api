package com.nhnacademy.minidooray.entity;

import com.nhnacademy.minidooray.auth.Auth;
import com.nhnacademy.minidooray.status.ProjectStatus;
import com.nhnacademy.minidooray.status.UserStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password", nullable = false, length = 50)
    private String userPassword;

    @Column(name = "user_email", nullable = false, length = 50)
    private String email;

    @Setter
    @Column(name = "user_auth", nullable = false)
    @Enumerated(EnumType.STRING)
    private Auth auth;

    @Column(name = "user_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Comment> comments;

    public User(String userId, String userPassword, String email, Auth auth, UserStatus userStatus) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.auth = auth;
        this.userStatus = userStatus;
    }

    public void addComment(Comment comment) {
        comment.setUser(this);
        comments.add(comment);
    }
}
