package com.tiago.service.impl;

import com.tiago.domain.User;
import com.tiago.repository.UserRepository;
import com.tiago.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by F on 2017/4/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByNameAndAddress(String name, String address) {
        return userRepository.findByNameAndAddress(name,address);
    }

    @Override
    public List<User> findDistinctByAddress(String address) {
        return userRepository.findDistinctByAddress(address);
    }

    @Override
    public List<User> findByNameIgnoreCase(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<User> findByNameAndAddressAllIgnoreCase(String name, String address) {
        return userRepository.findByNameAndAddressAllIgnoreCase(name,address);
    }

    @Override
    public List<User> findByNameOrderByIdDesc(String name) {
        return userRepository.findByNameOrderByIdDesc(name);
    }

    @Override
    public Page<User> findByName(String name, Pageable pageable) {
        return userRepository.findByName(name,pageable);
    }
}
