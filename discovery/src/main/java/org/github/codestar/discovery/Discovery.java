package org.github.codestar.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Discovery Service
 */
@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
public class Discovery {
    public static void main(String[] args) {
        SpringApplication.run(Discovery.class);
    }
}
