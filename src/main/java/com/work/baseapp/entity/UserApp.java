package com.work.baseapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users_app")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;  // Nama field disarankan 'id' (huruf kecil)

    private String username;

    private String email;

    private String password;

    @OneToOne (mappedBy = "userApp")
    private Avatar avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "transaction_user_role",
            joinColumns = @JoinColumn(name = "user_app_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    ) // Enum harus di-annotate agar disimpan sebagai string
    private List<Role> role;

    private Long created;

    private Long updated;

    private Boolean isActive;

    @OneToOne(mappedBy = "userApp")
    private Admin admin;

    @OneToOne(mappedBy = "userApp")
    private User user;
}
