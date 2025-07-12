package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CvService cvService;

    // Should be a UserDTO instead of User
    public void create(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void display(Integer userId) {
        userRepository.findById(userId).ifPresent(user -> {
            System.out.println("User: " + user.getName());
            cvService.display(user.getCvs());
        });
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
