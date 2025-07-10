package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "language_level")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String level;
}
