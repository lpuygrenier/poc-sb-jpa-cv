package com.example.demo.dto;

import java.util.List;

/**
 * This DTO is the DTO that we get from the frontend form
 */
public record CvFormDTO(
    Integer id,
    Integer userId,
    List<CvLanguageFormDTO> languages
) {}
