package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repo.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CvService cvService;

    public UserDTO create(UserDTO user) {
        var u = userRepository.save(userMapper.toEntity(user));
        return userMapper.toDTO(u);
    }

    public void display(Integer userId) {
        userRepository.findById(userId).ifPresent(user -> {
            System.out.println("User: " + user.getName());
            cvService.display(user.getCvs());
        });
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public UserDTO findUserByName(String name) {
        return userRepository.findUserByName(name)
                             .map(userMapper::toDTO)
                             .orElseThrow();
    }
}
