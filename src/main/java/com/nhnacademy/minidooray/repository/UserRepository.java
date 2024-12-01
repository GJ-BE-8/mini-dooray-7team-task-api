package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
