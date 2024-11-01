package com.djungleacademy.controllers;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.dto.common.ApiInfo;
import com.djungleacademy.dto.common.LoginRequest;
import com.djungleacademy.security.JwtToken;
import com.djungleacademy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;
    private final UserService userService;



    @PostMapping("/login")
    public ResponseEntity<ApiInfo<?>> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtToken.generateToken(loginRequest.getEmail());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ApiInfo.successReturn("Here is the token: ", jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiInfo.failure("Authentication failed due to: " + e.getMessage()));
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<ApiInfo<?>> logout(HttpServletRequest request) {
        String token=request.getHeader(HttpHeaders.AUTHORIZATION).substring(7);
        jwtToken.destroyToken(token);
        SecurityContextHolder.clearContext();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Logout successful", null));

    }


}
