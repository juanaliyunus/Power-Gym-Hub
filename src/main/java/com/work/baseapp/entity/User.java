package com.work.baseapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "m_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String address;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_app_id")
    private UserApp userApp;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)  // Relasi One-to-Many ke Task
    private List<Task> tasks;
}
