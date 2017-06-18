package org.github.codestar.crawler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * This is the entry class for the Spring Boot application, and will automatically scan
 */
@SpringBootApplication
public class CrawlerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CrawlerApplication.class).web(true).run(args);
    }
}
