package com.sunglowsys.service;

import com.sunglowsys.domain.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);
}
