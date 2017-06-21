package org.github.codestar.crawler.service.impl;

import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubService;
import org.springframework.stereotype.Service;

/**
 * Created by leo on 16.06.17.
 */
@Service
public class GitHubServiceImpl implements GitHubService {

    //TODO:: Implement discover By Name
    @Override
    public User discoverByUserName(String username) {
        return null;
    }

    //TODO:: Implement discover By Id
    @Override
    public User discoverById(long id) {
        return null;
    }
}
