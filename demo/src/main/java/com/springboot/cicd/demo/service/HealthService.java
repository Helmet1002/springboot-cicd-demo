package com.springboot.cicd.demo.service;

import com.springboot.cicd.demo.config.AppConfig;
import com.springboot.cicd.demo.dto.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class HealthService {

    @Value("${BUILD_VERSION:unknown}")
    private String buildVersion;
    private final AppConfig appConfig;

    public HealthService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public HealthResponse getHealthDetails() {
        return new HealthResponse(
                appConfig.getName(),
                buildVersion,
                appConfig.getCustomValue(),
                Instant.now()
        );
    }
}
