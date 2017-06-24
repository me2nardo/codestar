package org.github.codestar.crawler.config;

import org.github.codestar.crawler.util.rest.HeaderRequestInterceptor;
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
public class RestConfig {

    //TODO : Add external auth properties
    //TODO : Error interceptor for github
    //TODO : Header interceptor and rate checker
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        List<HeaderRequestInterceptor> headerInterceptor = new ArrayList<>();
        headerInterceptor.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
        headerInterceptor.add(new HeaderRequestInterceptor("Content-type",MediaType.APPLICATION_JSON_VALUE));
        headerInterceptor.add(new HeaderRequestInterceptor("Authorization: token",""));
        headerInterceptor.add(new HeaderRequestInterceptor("User-Agent","CodeStarApp"));

        return restTemplateBuilder.rootUri("https://api.github.com").build();
    }
}
