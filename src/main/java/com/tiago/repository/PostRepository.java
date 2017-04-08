package com.tiago.repository;

import com.tiago.domain.Post;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by F on 2017/4/8.
 */
public interface PostRepository extends Repository<Post,Long> {
    //属性表达式
    List<Post> findByUserName(String name);
    List<Post> findByUser_Address(String address);
}
