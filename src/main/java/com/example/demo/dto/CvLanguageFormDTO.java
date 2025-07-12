package com.example.demo.dto;
/**
 * This DTO is the DTO that we get from the frontend form
 */
public record CvLanguageFormDTO(
    Integer languageId,
    Integer languageLevelId
) {}
