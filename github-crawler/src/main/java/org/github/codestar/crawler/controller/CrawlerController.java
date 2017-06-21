package org.github.codestar.crawler.controller;

import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubService;
import org.neo4j.ogm.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * Provides a single REST endpoint for seeding users to crawl on GitHub. Automated
 * crawling of GitHub users requires three seed users as input.
 */
@RestController
@RequestMapping(value = "/api")
public class CrawlerController {

    private final GitHubService gitHubService;

    public CrawlerController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(value = "/discover/{name}")
    public ResponseEntity<User> discoverProfileByName(@PathVariable("name") String name){
         return Optional.of(ResponseEntity.ok(gitHubService.discoverByUserName(name)))
                 .orElseThrow(()-> new NotFoundException());
    }
}
