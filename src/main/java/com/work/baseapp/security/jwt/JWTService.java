package com.work.baseapp.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.work.baseapp.dto.response.JWTClaims;
import com.work.baseapp.entity.UserApp;

public interface JWTService {
    String generateToken(UserApp userApp);
    boolean verifyJwtToken(String token);
    DecodedJWT getDecodedJWT(String token);
    JWTClaims getClaimsByToken(String token);
}
