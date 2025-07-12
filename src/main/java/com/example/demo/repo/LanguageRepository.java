package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
