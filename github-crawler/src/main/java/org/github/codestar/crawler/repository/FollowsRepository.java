package org.github.codestar.crawler.repository;

import org.github.codestar.crawler.model.Follows;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *  The {@link Follows} repository provides custom Cypher queries as repository search operations
 *
 *  @author vitalii.levash
 */
public interface FollowsRepository extends GraphRepository<Follows> {
}
