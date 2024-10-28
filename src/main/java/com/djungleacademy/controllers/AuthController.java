package com.djungleacademy.controllers;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.dto.common.ApiInfo;
import com.djungleacademy.dto.common.LoginRequest;
import com.djungleacademy.security.JwtToken;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
            // 输出更详细的错误信息
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiInfo.failure("Invalid username or password"));
        }

    }

    @GetMapping("/userinfo")
    public ResponseEntity<ApiInfo<?>> getUserInfo() {
        // 获取当前认证的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // 假设用户信息是以 UserDTO 的形式存储在 Authentication 对象中
            var email = authentication.getPrincipal();
            UserDTO userDTO=userService.findByEmail((String) email);

            // 返回用户信息
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ApiInfo.successReturn("User information retrieved successfully", userDTO));
        } else {
            // 若认证信息不存在或无效
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiInfo.failure("Invalid or expired token"));
        }
    }
}
