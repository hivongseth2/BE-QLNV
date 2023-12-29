package com.camera.projectcamera.security.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class JwtConfig {

        private final String secret = "3TD_TRAVELO";

    private final int expiration = 86400000;

    private final String algorithm = "HS256";

}