package com.camera.projectcamera.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public abstract class JwtService<T> {

    private static final JwtConfig jwtConfig = new JwtConfig();

    public String generateToken(T data) {
        long currentTime = System.currentTimeMillis();
        long expirationTime = currentTime + jwtConfig.getExpiration();
        return Jwts.builder()
                .setSubject(data.toString())
                .claim("data", data)
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(expirationTime))
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret())
                .compact();
    }

    public boolean validateToken(String jwt) {
        try {
            Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(jwt);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Token expired");
            return false;
        } catch (MalformedJwtException e){
            log.error("Token malformed");
            return false;
        } catch (UnsupportedJwtException e){
            log.error("Token unsupported");
            return false;
        } catch (IllegalArgumentException e){
            log.error("Token illegal argument");
            return false;
        }
    }

    public String getEmailFromToken(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }

    public Claims decodeToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            // Xử lý ngoại lệ khi Token không hợp lệ
            return null;
        }
    }
}