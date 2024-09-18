package com.work.baseapp.security;

import com.work.baseapp.dto.response.JWTClaims;
import com.work.baseapp.security.jwt.JWTService;
import com.work.baseapp.service.UserAppService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserAppService userAppService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtService.parseJWT(request);
            if (token != null && jwtService.verifyJwtToken(token)){
                JWTClaims userInfo = jwtService.getUserInfoByToken(token);
                log.info("User Info : " + userInfo.getUserId());
                log.info("User Info : " + userInfo.getRoles().stream().toList());
                UserDetails userDetails = userAppService.loadUserById(userInfo.getUserId());
                log.info("User Details " + userDetails.getAuthorities());
                log.info("Roles :" + userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
