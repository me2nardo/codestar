package org.github.codestar.crawler.config;

import org.github.codestar.crawler.config.properties.GitHubProperties;
import org.github.codestar.crawler.util.rest.HeaderRequestInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Root config for github api
 */
@Configuration
@EnableConfigurationProperties(GitHubProperties.class)
public class RestConfig {

    private final GitHubProperties gitHubProperties;

    public RestConfig(GitHubProperties gitHubProperties) {
        this.gitHubProperties = gitHubProperties;
    }

    //TODO : Add external auth properties +
    //TODO : Error interceptor for github
    //TODO : Header interceptor and rate checker
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        List<HeaderRequestInterceptor> headerInterceptor = new ArrayList<>();
        headerInterceptor.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
        headerInterceptor.add(new HeaderRequestInterceptor("Content-type",MediaType.APPLICATION_JSON_VALUE));
        headerInterceptor.add(new HeaderRequestInterceptor("Authorization: token",gitHubProperties.getToken()));
        headerInterceptor.add(new HeaderRequestInterceptor("User-Agent",gitHubProperties.getUserAgent()));

        return restTemplateBuilder.additionalInterceptors(headerInterceptor)
                .rootUri(gitHubProperties.getUrl())
                .build();
    }
}
