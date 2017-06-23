package org.github.codestar.crawler.service;

import org.github.codestar.crawler.model.User;

import java.util.List;

/**
 * Created by vlevash on 21.06.17.
 */
public interface GitHubApi {

    User extractUser(String username);
    List<User> extractSubUsers(String username,String param);

}
