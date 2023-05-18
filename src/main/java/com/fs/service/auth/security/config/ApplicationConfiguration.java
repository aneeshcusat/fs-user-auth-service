package com.fs.service.auth.security.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationConfiguration {

    @Value("${app.application.name}")
    private String applicationName;

    @Value("${app.host.name}")
    private String hostName;

    @Value("${app.security.cors.allowedOrigins}")
    private String[] corsAllowedOrigins;

    @Value("${app.security.cors.allowedMethods}")
    private String[] corsAllowedMethods;

    @Value("${app.security.cors.allowedHeaders}")
    private String[] corsAllowedHeaders;
}
