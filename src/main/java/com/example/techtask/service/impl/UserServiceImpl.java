package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.CustomUserRepository;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CustomUserRepository userRepository;

    @Override
    public User findUser() {
        return userRepository.findMaxDeliveredSumIn2003User();
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findPaidOrdersIn2010Users();
    }
}
