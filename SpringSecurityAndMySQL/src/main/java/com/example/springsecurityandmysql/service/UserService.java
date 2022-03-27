package com.example.springsecurityandmysql.service;

import com.example.springsecurityandmysql.model.User;
import com.example.springsecurityandmysql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private static final String UNKNOWN_USER = "User is absent";
    private static final String USER_NAME_LABEL = "User name: ";

    final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String getUserNameById(final Long id) {
        final User user = userRepository.findById(id).orElse(null);
        return Objects.nonNull(user)
                ? USER_NAME_LABEL + user.getFirstName()
                : USER_NAME_LABEL + UNKNOWN_USER;
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
