package com.work.baseapp.entity;

import jakarta.persistence.JoinColumn;

import java.util.List;

import com.work.baseapp.constant.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Admin {
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
}
