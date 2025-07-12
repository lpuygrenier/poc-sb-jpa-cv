package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        cvService.displayAllCvInDatabase();

        // Création CV pour tout le monde
        cvService.save(Data.cv1);
        cvService.save(Data.cv2);
        cvService.save(Data.cv3);

        cvService.displayAllCvInDatabase();

        // Création d'un deuxième CV pour le même user
        cvService.save(Data.cv4);
        userService.display(Data.EMIE);

        // Modification du CV
        cvService.save(Data.cv4m);
        userService.display(Data.EMIE);

        // Création User, CV
        userService.create(Data.plini);
        cvService.save(Data.cv5);
        userService.display(Data.PLINI);
        cvService.save(Data.cv5m);
        userService.display(Data.PLINI);

        cvService.displayAllCvInDatabase();

        // Cleanup database
        // restart cv_seq_id
        // TODO
    }
}