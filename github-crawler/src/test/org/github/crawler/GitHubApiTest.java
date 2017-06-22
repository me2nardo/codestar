package org.github.crawler;

import org.github.codestar.crawler.CrawlerApplication;
import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by vlevash on 22.06.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrawlerApplication.class)
public class GitHubApiTest {

    @Autowired
    private GitHubApi gitHubApi;

    @Test
    public void testApi(){
        boolean user = Optional.of(gitHubApi.extractUser("me2nardos")).isPresent();
        System.out.println(user);
    }
}
