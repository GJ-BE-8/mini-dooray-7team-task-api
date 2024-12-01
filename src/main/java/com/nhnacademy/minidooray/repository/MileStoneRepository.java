package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.entity.MileStone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileStoneRepository extends JpaRepository<MileStone, Long> {
    MileStone findByTask_TaskId(Long taskId);
}
