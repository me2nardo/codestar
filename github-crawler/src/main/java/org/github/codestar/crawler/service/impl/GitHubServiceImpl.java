package org.github.codestar.crawler.service.impl;

import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.repository.FollowsRepository;
import org.github.codestar.crawler.repository.UserRepository;
import org.github.codestar.crawler.service.GitHubApi;
import org.github.codestar.crawler.service.GitHubService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by leo on 16.06.17.
 */
@Service
public class GitHubServiceImpl implements GitHubService {

    private final String QUEUE_NAME = "q:extract";

    private final GitHubApi gitHubApi;
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    public GitHubServiceImpl(GitHubApi gitHubApi, UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        this.gitHubApi = gitHubApi;
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public User discoverByUserName(String username) {
        User user = gitHubApi.extractUser(username);

        user.setImported(true);
        user.setCurrentRank(0);
        user.setLastPageRank(0F);

        user = userRepository.save(user);

        if (user.getFollowers() > 0 && user.getFollowing() > 0) {
            rabbitTemplate.convertAndSend(QUEUE_NAME,user);
        }

        return user;
    }

    //TODO:: Implement discover By Id
    @Override
    public User discoverById(long id) {
        return null;
    }
}
