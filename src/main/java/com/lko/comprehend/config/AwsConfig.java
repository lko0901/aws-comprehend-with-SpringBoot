package com.lko.comprehend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cloud.aws")
public class AwsConfig {
    private String region;
    private String credentialsAccessKey;
    private String credentialsSecretKey;
}
