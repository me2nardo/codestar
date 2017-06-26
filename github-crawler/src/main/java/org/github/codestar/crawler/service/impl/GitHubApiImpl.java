package org.github.codestar.crawler.service.impl;

import org.github.codestar.crawler.model.RateLimit;
import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlevash on 22.06.17.
 */
@Service
public class GitHubApiImpl implements GitHubApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubApiImpl.class);

    private final String API = "https://api.github.com/users/{username}";
    private final String PARAM = API +"/{PARAM}";
    private final RestTemplate restTemplate;


    public GitHubApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
/*
    private RateLimit initRateLimit(){
        return restTemplate.getForEntity(API,RateLimit.class).getBody();
    }
*/
    // TODO: add limit counter https://api.github.com/rate_limit check avery 30 sec

    @Override
    public User extractUser(String username) {
        Map<String,String> params = new HashMap<>();
        params.put("username",username);

        ResponseEntity<User> user = restTemplate.getForEntity(API,User.class,params);
        LOGGER.debug("[API] GitHub extract:{}"+user);
        if (user.getStatusCodeValue()!=200){
            throw new IllegalArgumentException(username);
        }
        return user.getBody();
    }

    public List<User> extractSubUsers(String username,String param){
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("param",param);

        User[] userList = restTemplate.getForObject(PARAM,User[].class,params);
        LOGGER.debug("[API] GitHub param size:" + userList.length);
        return Arrays.asList(userList);
    }
}
