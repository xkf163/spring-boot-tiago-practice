package com.tiago.repository;

import com.tiago.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by F on 2017/4/8.
 */

public interface UserRepository extends Repository<User,Long> , QueryDslPredicateExecutor<User> {



    List<User> findByNameAndAddress(String name, String address);

    //查找非重复行
    List<User> findDistinctByAddress(String address);

    //忽略大小写
    List<User> findByNameIgnoreCase(String name);
    List<User> findByNameAndAddressAllIgnoreCase(String name,String address);


    //排序
    List<User> findByNameOrderByIdDesc(String name);


    Page<User> findByName(String name , Pageable pageable);

 }
