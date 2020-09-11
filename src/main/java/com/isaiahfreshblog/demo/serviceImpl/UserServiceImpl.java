package com.isaiahfreshblog.demo.serviceImpl;

import com.isaiahfreshblog.demo.models.User;
import com.isaiahfreshblog.demo.repositories.UserRepository;
import com.isaiahfreshblog.demo.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
