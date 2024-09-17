package com.work.baseapp.security.jwt.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.work.baseapp.dto.response.JWTClaims;
import com.work.baseapp.entity.UserApp;
import com.work.baseapp.security.jwt.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class JWTServiceImpl implements JWTService {
    @Value("${app.base-app.jwt.app-name}")
    private String appName;
    @Value("${app.base-app.jwt.expiration}")
    private long expirationInSecond;
    @Value("${app.base-app.jwt.secret}")
    private String secretKey;

    private static final String ROLES_CLAIM = "roles";

    @Override
    public String generateToken(UserApp userApp) {
        try {
            List<String> roles = userApp
                    .getRole()
                    .stream()
                    .map(roleUserApp -> roleUserApp.getRole().name()).toList();

           return JWT
                   .create()
                   .withIssuer(appName)
                   .withSubject(userApp.getId())
                   .withExpiresAt(Instant.now().plusSeconds(expirationInSecond))
                   .withClaim(ROLES_CLAIM, roles)
                   .sign(Algorithm.HMAC512(secretKey));

        } catch (JWTCreationException e) {
            log.error("Invalid while creating jwt token : {}",e.getMessage());
            throw new RuntimeException("Error creating JWT token", e);
        }
    }

    @Override
    public boolean verifyJwtToken(String token) {
        try {
            DecodedJWT decodedJWT = getDecodedJWT(token);
            if (decodedJWT == null) return false;
            return decodedJWT.getIssuer().equals(appName);
        } catch (JWTVerificationException e) {
            log.error("Invalid JWT Signature/Claims : {}", e.getMessage());
            return false;
        }
    }

    @Override
    public DecodedJWT getDecodedJWT(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            return jwtVerifier.verify(token);
        } catch (JWTDecodeException e) {
            log.error("Failed to decode JWT token: Invalid token format or signature. Error message: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public JWTClaims getClaimsByToken(String token) {
        try {
            DecodedJWT decodedJWT = getDecodedJWT(token);
            if (decodedJWT == null) {
                log.error("Failed to extract claims from JWT: Decoded JWT is null");
                return null;
            }
            List<String> roles = decodedJWT.getClaim(ROLES_CLAIM).isNull() ? Collections.emptyList() : decodedJWT.getClaim(ROLES_CLAIM).asList(String.class);
            return JWTClaims.builder()
                    .userId(decodedJWT.getSubject())
                    .roles(roles)
                    .build();
        } catch (JWTVerificationException e) {
            log.error("JWT verification failed: Invalid token or signature. Error message: {}", e.getMessage());
            return null;
        }
    }
}
