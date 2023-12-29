package com.camera.projectcamera.security.service;


import com.camera.projectcamera.security.jwt.JwtService;
import com.camera.projectcamera.security.jwt.UserJwt;
import org.springframework.stereotype.Service;

@Service
public class UserJwtService extends JwtService<UserJwt> {
}