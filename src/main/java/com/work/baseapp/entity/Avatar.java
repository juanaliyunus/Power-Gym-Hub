package com.work.baseapp.entity;

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
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String path;

    private Long size;

    private String contentType;

    private Long uploadDate;  // Tanggal upload atau pembuatan avatar// Getter and Setter methods

    @OneToOne
    @JoinColumn(name = "user_app_id")
    private UserApp userApp;
}
