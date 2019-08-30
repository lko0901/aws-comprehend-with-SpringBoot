package com.lko.awstest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AwsTestApplication {
    private static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "classpath:application-local.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(AwsTestApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}
