package com.djungleacademy.security;

import com.djungleacademy.exceptions.JwtValidationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtToken {

    @Value("${spring.jwt.secret}")
    private String secretKey;

    @Value("${spring.jwt.expiration}")
    private long expirationTime;

    private SecretKey getKey() {
        // 方法1：使用 JJWT 内置的密钥生成器
//        return Jwts.SIG.HS512.key().build();

        // 或者方法2：如果要使用配置的密钥，确保它足够长
        String defaultKey = "ThisIsADefaultKeyForFulfillTheSize";
        String combinedKey = secretKey + defaultKey; // 将用户密码与默认密钥结合
        return Keys.hmacShaKeyFor(combinedKey.getBytes(StandardCharsets.UTF_8));

    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            throw new JwtValidationException("Invalid JWT token: " + e.getMessage());
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
}