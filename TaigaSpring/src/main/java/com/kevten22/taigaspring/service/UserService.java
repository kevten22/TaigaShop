package com.kevten22.taigaspring.service;

import com.kevten22.taigaspring.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
