package org.github.codestar.crawler.repository;

import org.github.codestar.crawler.model.User;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *  The {@link User} repository provides custom Cypher queries as repository search operations
 */
public interface UserRepository extends GraphRepository<User> {
}
