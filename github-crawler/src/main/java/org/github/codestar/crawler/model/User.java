package org.github.codestar.crawler.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the {@link User} domain class that represents a GitHib profile as a Neo4j node
 *
 * @author vitalii.levash
 */
@NodeEntity
public class User implements Serializable{

    @GraphId
    private Long id;

    @Index(unique = true)
    private Long profileId;

    @Relationship(type = "FOLLOWS", direction = "OUTGOING")
    private Set<User> follow = new HashSet<>();

    @Relationship(type = "FOLLOWS", direction = "INCOMING")
    private Set<User> follower = new HashSet<>();

    private String login;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String company;
    private int followers;
    private int following;
    private Date createdAt;
    private Float pagerank;
    private Integer previousRank;
    private Integer currentRank;
    private Float lastPageRank;
    private Boolean imported;
    private Long discoveredTime;
    private Integer discoveredRank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Set<User> getFollow() {
        return follow;
    }

    public void setFollow(Set<User> follow) {
        this.follow = follow;
    }

    public Set<User> getFollower() {
        return follower;
    }

    public void setFollower(Set<User> follower) {
        this.follower = follower;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Float getPagerank() {
        return pagerank;
    }

    public void setPagerank(Float pagerank) {
        this.pagerank = pagerank;
    }

    public Integer getPreviousRank() {
        return previousRank;
    }

    public void setPreviousRank(Integer previousRank) {
        this.previousRank = previousRank;
    }

    public Integer getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    public Float getLastPageRank() {
        return lastPageRank;
    }

    public void setLastPageRank(Float lastPageRank) {
        this.lastPageRank = lastPageRank;
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public Long getDiscoveredTime() {
        return discoveredTime;
    }

    public void setDiscoveredTime(Long discoveredTime) {
        this.discoveredTime = discoveredTime;
    }

    public Integer getDiscoveredRank() {
        return discoveredRank;
    }

    public void setDiscoveredRank(Integer discoveredRank) {
        this.discoveredRank = discoveredRank;
    }
}
