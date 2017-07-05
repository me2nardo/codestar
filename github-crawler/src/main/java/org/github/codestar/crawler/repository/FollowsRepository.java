package org.github.codestar.crawler.repository;

import org.github.codestar.crawler.model.Follows;
import org.github.codestar.crawler.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 *  The {@link Follows} repository provides custom Cypher queries as repository search operations
 *
 *  @author vitalii.levash
 */
public interface FollowsRepository extends GraphRepository<Follows> {

    /**
     * Efficiently batches the creation of many FOLLOWS relationships
     * between {@link User} nodes
     *
     * @param follows a set of relationship entities containing a user "A" who follows a user "B"
     */
    @Query("FOREACH(x in {follows} | MERGE (a:User { profileId: x.userA.profileId })\n" +
            "MERGE (b:User { profileId: x.userB.profileId })\n" +
            "MERGE (a)-[:FOLLOWS]->(b))")
    void saveFollows(@Param("follows") Set<Follows> follows);
}
