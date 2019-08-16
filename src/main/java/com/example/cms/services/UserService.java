package com.example.cms.services;

import com.example.cms.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
