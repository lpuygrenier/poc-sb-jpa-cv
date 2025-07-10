package com.example.demo;

import org.springframework.stereotype.Service;
import lombok.*;

@Service
@AllArgsConstructor
public class CvService {

    private final CvRepository cvRepository;

    public void display() {
        System.out.println("All Cvs in database:");
        cvRepository.findAll().forEach(cv -> {
            System.out.println("Cv: " + cv.getId() + " - " + cv.getName());
            cv.getCvLanguages().forEach(cvLang -> {
                System.out.println("  Language: " + cvLang.getLanguage().getName() +
                                    ", Level: " + cvLang.getLanguageLevel().getLevel());
            });
        });
    }
}
