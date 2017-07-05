package org.github.codestar.crawler.repository;

import org.github.codestar.crawler.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

/**
 *  The {@link User} repository provides custom Cypher queries as repository search operations
 */
public interface UserRepository extends GraphRepository<User> {

    User findUserByLogin(String login);

    @Query("MATCH (user:User { profileId: {profileId} }) RETURN id(user) as id")
    Long getUserIdByProfileId(@Param("profileId") Long profileId);



}
