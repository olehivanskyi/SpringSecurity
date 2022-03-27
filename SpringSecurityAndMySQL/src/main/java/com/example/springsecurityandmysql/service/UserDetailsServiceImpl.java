package com.example.springsecurityandmysql.service;

import com.example.springsecurityandmysql.model.SecurityUser;
import com.example.springsecurityandmysql.model.User;
import com.example.springsecurityandmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USER_ABSENT = "User doesn't exist";

    @Autowired
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_ABSENT));
        return SecurityUser.fromUser(user);
    }
}
