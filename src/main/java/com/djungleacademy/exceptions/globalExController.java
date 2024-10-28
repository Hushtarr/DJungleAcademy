package com.djungleacademy.exceptions;

import com.djungleacademy.dto.common.ApiInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class globalExController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiInfo<Void>> handleGenericException(Exception ex) {
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiInfo.failure("An unexpected error occurred: " + ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiInfo<Void>> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.warn("Invalid argument: {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiInfo.failure("Invalid argument: " + ex.getMessage()));
    }

    @ExceptionHandler(JwtValidationException.class)
    public ResponseEntity<ApiInfo<Void>> handleJwtValidationException(JwtValidationException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ApiInfo.failure("JWT validation failed: " + ex.getMessage()));
    }


}
