package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CvLanguageId implements Serializable {
    private Integer cvId;
    private Integer languageId;
    private Integer levelId;
}