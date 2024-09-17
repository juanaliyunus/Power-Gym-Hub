package com.work.baseapp.dto.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTClaims {
    private String userId;
    private List<String> roles;
}
