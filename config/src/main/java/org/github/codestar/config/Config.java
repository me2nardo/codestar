package org.github.codestar.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config server
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class Config {

    public static void main(String[] args) {
        SpringApplication.run(Config.class);
    }
}
