package com.springboot.cicd.demo.service;

import com.springboot.cicd.demo.config.AppConfig;
import com.springboot.cicd.demo.dto.HealthResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HealthServiceTest {

    private AppConfig appConfig;
    private HealthService healthService;

    @BeforeEach
    void setUp() {
        appConfig = Mockito.mock(AppConfig.class);
        healthService = new HealthService(appConfig);
        ReflectionTestUtils.setField(healthService, "buildVersion", "1.0.0-test");
    }

    @Test
    void shouldReturnHealthDetails() {
        // Arrange
        when(appConfig.getName()).thenReturn("demo-app");
        when(appConfig.getCustomValue()).thenReturn("custom123");

        // Act
        HealthResponse response = healthService.getHealthDetails();

        // Assert
        assertNotNull(response);
        assertEquals("demo-app", response.getAppName());
        assertEquals("1.0.0-test", response.getBuildVersion());
        assertEquals("custom123", response.getConfigValue());
        assertNotNull(response.getTimestamp());
    }
}