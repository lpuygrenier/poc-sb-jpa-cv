package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cv_language")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvLanguage {
    @EmbeddedId
    private CvLanguageId id;

    @ManyToOne
    @MapsId("cvId")
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @MapsId("levelId")
    @JoinColumn(name = "level_id")
    private LanguageLevel languageLevel;
}
