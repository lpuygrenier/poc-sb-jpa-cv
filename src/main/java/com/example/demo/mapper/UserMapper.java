package com.example.demo.mapper;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

@Service
public class UserMapper {
    public User toEntity(UserDTO user) {
        if (user == null) {
            return null;
        }

        return User.builder()
                   .id(user.id())
                   .name(user.name())
                   .build();
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getId(), user.getName());
    }
}
