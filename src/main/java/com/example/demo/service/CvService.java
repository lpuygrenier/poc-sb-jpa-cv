package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CvDTO;
import com.example.demo.dto.CvFormDTO;
import com.example.demo.entity.Cv;
import com.example.demo.entity.CvLanguage;
import com.example.demo.entity.CvLanguageId;
import com.example.demo.mapper.CvMapper;
import com.example.demo.repo.CvRepository;
import com.example.demo.repo.LanguageLevelRepository;
import com.example.demo.repo.LanguageRepository;
import com.example.demo.repo.UserRepository;

import jakarta.transaction.Transactional;
import lombok.*;

@Service
@AllArgsConstructor
public class CvService {

    private final CvRepository cvRepository;
    private final CvMapper cvMapper;
    private final LanguageLevelRepository languageLevelRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;

    public CvDTO save(CvFormDTO cvFormDTO) {
        var cv = cvRepository.save(toEntity(cvFormDTO));
        return cvMapper.toDTO(cv);
    };

    @Transactional
    public void displayAllCvInDatabase() {
        System.out.println("All Cvs in database:");
        cvRepository.findAll().forEach(cv -> {
            System.out.println("Cv: " + cv.getId() + " - " + cv.getUser().getName());
            cv.getCvLanguages().forEach(cvLang -> {
                System.out.println("  Language: " + cvLang.getLanguage().getName() +
                                    ", Level: " + cvLang.getLanguageLevel().getLevel());
            });
        });
    }

    public void display(List<Cv> cvs) {
        cvs.forEach(cv -> {
            System.out.println("Cv: " + cv.getId() + " - " + cv.getUser().getName());
            cv.getCvLanguages().forEach(cvLang -> {
                System.out.println("  Language: " + cvLang.getLanguage().getName() +
                                    ", Level: " + cvLang.getLanguageLevel().getLevel());
            });
        });
    }

    private Cv toEntity(CvFormDTO cvFormDTO) {
        var user = userRepository.findById(cvFormDTO.userId()).orElseThrow();
        Cv cv;

        // Creation
        // TODO: Make Hibernate manage the idCv in CvLanguage (if possible)
        if (cvFormDTO.id() == null) {
            cv = Cv.builder()
                .user(user)
                .build();

            var savedCv = cvRepository.save(cv);
            savedCv.setCvLanguages(buildCvLanguages(savedCv, cvFormDTO));

            cvRepository.save(savedCv);
        } 
        // Modification
        else {
            cv = cvRepository.findById(cvFormDTO.id()).orElseThrow();
            cv.setUser(user);
            cv.setCvLanguages(buildCvLanguages(cv, cvFormDTO));
        }
 
        return cv;
    }


    private List<CvLanguage> buildCvLanguages(Cv savedCv, CvFormDTO cvFormDTO) {
        List<CvLanguage> cvs = new ArrayList<>();
        cvFormDTO.languages().forEach(language -> {
            var l = languageRepository.findById(language.languageId()).orElseThrow();
            var ll = languageLevelRepository.findById(language.languageLevelId()).orElseThrow();

            CvLanguage cvLang = new CvLanguage();
            // Are they usefull when saving ?
            cvLang.setLanguage(l);
            cvLang.setLanguageLevel(ll);
            cvLang.setCv(savedCv);
            //
            cvLang.setId(new CvLanguageId(savedCv.getId(), l.getId(), ll.getId()));

            cvs.add(cvLang);
        });

        return cvs;
    }

}
