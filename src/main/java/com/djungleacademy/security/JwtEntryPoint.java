package com.djungleacademy.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private static final String UNAUTHORIZED_MESSAGE = "Unauthorized: You need to log in to access this resource.";
    private static final String CONTENT_TYPE = "application/json";
    private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    private final ObjectMapper objectMapper;

    public JwtEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 设置响应类型为 JSON
        response.setContentType(CONTENT_TYPE);
        // 设置 HTTP 状态为 401 Unauthorized
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 输出未授权错误信息
        Map<String, Object> responseBody = Map.of(
                "success", false,
                "message", UNAUTHORIZED_MESSAGE,
                "error", authException.getMessage() // 添加异常信息
        );

        // 记录日志
        logger.warn("Unauthorized access attempt: {}", request.getRequestURI());

        response.getWriter().write(objectMapper.writeValueAsString(responseBody));
    }
}
