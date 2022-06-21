package com.jobayed.standalonesecurity.authentication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Long saveUser(String username, String password, String role) {
        User user = new User(null, username, passwordEncoder.encode(password), role);
        Long userId = repository.save(user).getId();
        return userId;
    }
}
