package com.work.baseapp.entity;

import com.work.baseapp.constant.ERole;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private ERole role;
}
