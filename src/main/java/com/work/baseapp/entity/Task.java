package com.work.baseapp.entity;

import com.work.baseapp.constant.Priority;
import com.work.baseapp.constant.TaskStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String description;

    private Long dueDate;

    private Long createdDate;

    private Long updatedDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
