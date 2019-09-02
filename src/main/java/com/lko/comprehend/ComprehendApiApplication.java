package com.lko.comprehend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ComprehendApiApplication {
    private static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "classpath:application-local.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComprehendApiApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}
