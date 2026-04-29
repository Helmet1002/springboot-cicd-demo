package com.springboot.cicd.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
@Data
@AllArgsConstructor
public class HealthResponse {

    private String appName;
    private String buildVersion;
    private String configValue;
    private Instant timestamp;
}
