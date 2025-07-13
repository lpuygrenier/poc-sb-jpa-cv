package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.CvFormDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.CvService;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final CvService cvService;
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userService.deleteAll();

        cvService.displayAllCvInDatabase();

        // Création des utilsateurs
        UserDTO armand = userService.create(new UserDTO(null, "armand"));
        UserDTO emie = userService.create(new UserDTO(null, "emie"));
        UserDTO leo = userService.create(new UserDTO(null, "leo"));

        // Création CV pour tout le monde
        cvService.save(new CvFormDTO(null, armand.id(), List.of(Data.FRENCH_A1, Data.ENGLISH_A1)));
        cvService.save(new CvFormDTO(null, emie.id(), List.of(Data.FRENCH_A2, Data.ENGLISH_A2)));
        cvService.save(new CvFormDTO(null, leo.id(), List.of(Data.FRENCH_B1, Data.ENGLISH_B1)));

        cvService.displayAllCvInDatabase();

        // Création d'un deuxième CV pour le même user
        var cv = cvService.save(new CvFormDTO(null, emie.id(), List.of(Data.FRENCH_B2, Data.GERMAN_B2, Data.ENGLISH_B2)));
        userService.display(emie.id());

        // Modification du CV
        cvService.save(new CvFormDTO(cv.id(), emie.id(), List.of(Data.FRENCH_B1, Data.ENGLISH_B1)));
        userService.display(emie.id());

        cvService.displayAllCvInDatabase();

        // Cleanup database
        userService.deleteAll();

    }
}