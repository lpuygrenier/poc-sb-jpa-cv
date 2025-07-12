package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cv")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CvLanguage> cvLanguages;

    public void addLanguage(CvLanguage language) {
        if (null == cvLanguages) {
            cvLanguages = new ArrayList<>();
        }
        cvLanguages.add(language);
        language.setCv(this);
    }
}
