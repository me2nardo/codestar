package org.github.codestar.crawler.service.impl;

import org.github.codestar.crawler.model.RateLimit;
import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vlevash on 22.06.17.
 */
@Service
public class GitHubApiImpl implements GitHubApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubApiImpl.class);

    private final String API = "https://api.github.com/";
    private final RestTemplate restTemplate;
    private int limit;
    private AtomicInteger remaining;
    private long reset;


    public GitHubApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // TODO: Write test for limits
    @PostConstruct
    private void initLimit(){
        String url = API + "/rate_limit";
        RateLimit rateLimit = restTemplate.getForEntity(url,RateLimit.class).getBody();

        this.limit = rateLimit.getLimit();
        this.remaining = new AtomicInteger(rateLimit.getRemaining());
        this.reset = rateLimit.getReset();
    }

    @Override
    public User extractUser(String username) {
        String url = API + "/users/{username}";
        Map<String,String> params = new HashMap<>();
        params.put("username",username);

        ResponseEntity<User> user = restTemplate.getForEntity(url,User.class,params);
        LOGGER.debug("[API] GitHub extract:{}"+user);
        if (user.getStatusCodeValue()!=200){
            throw new IllegalArgumentException(username);
        }
        return user.getBody();
    }

    public List<User> extractSubUsers(String username,String param){
        String url = API + "/users/{username}/{param}";
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("param",param);

        User[] userList = restTemplate.getForObject(url,User[].class,params);
        LOGGER.debug("[API] GitHub param size:" + userList.length);
        return Arrays.asList(userList);
    }
}
