package org.github.codestar.crawler.service;

import org.github.codestar.crawler.model.User;

/**
 * This service is a contract that provides user discovery based on either a user's screen name
 * or the profile's ID from the GitHub Api V3
 */
public interface GitHubService {

    User discoverByUserName(String username);
    User discoverById(long id);
}
