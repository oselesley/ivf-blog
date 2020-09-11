package com.isaiahfreshblog.demo.services;

import com.isaiahfreshblog.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(Long id);
    User getUser(String email);
    User createUser (User user);
}
