package com.work.baseapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users_app")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserApp implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream().map(roleUser -> new SimpleGrantedAuthority(roleUser.getRole().name())).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
