    package com.example.demo.mapper;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CvDTO;
import com.example.demo.entity.Cv;

@Service
public class CvMapper {

    public Cv toEntity(CvDTO cv) {
        if (cv == null) {
            return null;
        }

        return Cv.builder()
                   .id(cv.id())
                   .build();
    }

    public CvDTO toDTO(Cv cv) {
        if (cv == null) {
            return null;
        }
        return new CvDTO(cv.getId());
    }
}