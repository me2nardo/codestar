package org.github.codestar.crawler.listener;

import org.github.codestar.crawler.model.Follows;
import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.repository.FollowsRepository;
import org.github.codestar.crawler.service.GitHubApi;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vlevash on 22.06.17.
 */
@Component
public class SubUserExtractor {

    private final FollowsRepository followsRepository;
    private final GitHubApi gitHubApi;

    public SubUserExtractor(FollowsRepository followsRepository, GitHubApi gitHubApi) {
        this.followsRepository = followsRepository;
        this.gitHubApi = gitHubApi;
    }

    @RabbitListener(id="extract",queues = "q:extract")
    public void extractSubUsers(User user){
        //TODO:: implement extractUser
        List<User> userList = gitHubApi.extractSubUsers(user.getLogin(),"followers");
        userList.stream().forEach(row->followsRepository.save(new Follows(user,row)));

    }
}
