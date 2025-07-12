package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LanguageLevel;

public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, Integer> {
}
