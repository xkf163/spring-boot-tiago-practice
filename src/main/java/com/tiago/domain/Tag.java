package com.tiago.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by F on 2017/4/8.
 */
@Entity
@Table
public class Tag extends BaseDomain {

    private String name;

    @ManyToMany
    @JoinTable(name = "post_tag",joinColumns = @JoinColumn(name = "tag_id"),inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> posts = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
