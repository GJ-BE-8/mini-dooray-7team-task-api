package com.nhnacademy.minidooray.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MileStone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_id")
    private long milestoneId;

    @Column(name = "milestone_name", nullable = false, length = 50)
    private String milestoneName;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public MileStone(String milestoneName)  {
        this.milestoneName = milestoneName;
    }
}
