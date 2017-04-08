package com.tiago.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by F on 2017/4/8.
 */
@Entity
@Table
public class Category extends BaseDomain {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
