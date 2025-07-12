package com.example.demo;

import java.util.List;

import com.example.demo.dto.CvFormDTO;
import com.example.demo.dto.CvLanguageFormDTO;
import com.example.demo.entity.User;

public class Data {
    public static final Integer FRENCH_ID = 1; 
    public static final Integer ENGLISH_ID = 2; 
    public static final Integer GERMAN_ID = 3; 

    public static final Integer A1_ID = 1; 
    public static final Integer A2_ID = 2; 
    public static final Integer B1_ID = 3; 
    public static final Integer B2_ID = 4; 

    public static final CvLanguageFormDTO FRENCH_A1 = new CvLanguageFormDTO(FRENCH_ID, A1_ID);
    public static final CvLanguageFormDTO FRENCH_A2 = new CvLanguageFormDTO(FRENCH_ID, A2_ID);
    public static final CvLanguageFormDTO FRENCH_B1 = new CvLanguageFormDTO(FRENCH_ID, B1_ID);
    public static final CvLanguageFormDTO FRENCH_B2 = new CvLanguageFormDTO(FRENCH_ID, B2_ID);

    public static final CvLanguageFormDTO ENGLISH_A1 = new CvLanguageFormDTO(ENGLISH_ID, A1_ID);
    public static final CvLanguageFormDTO ENGLISH_A2 = new CvLanguageFormDTO(ENGLISH_ID, A2_ID);
    public static final CvLanguageFormDTO ENGLISH_B1 = new CvLanguageFormDTO(ENGLISH_ID, B1_ID);
    public static final CvLanguageFormDTO ENGLISH_B2 = new CvLanguageFormDTO(ENGLISH_ID, B2_ID);

    public static final CvLanguageFormDTO GERMAN_A1 = new CvLanguageFormDTO(GERMAN_ID, A1_ID);
    public static final CvLanguageFormDTO GERMAN_A2 = new CvLanguageFormDTO(GERMAN_ID, A2_ID);
    public static final CvLanguageFormDTO GERMAN_B1 = new CvLanguageFormDTO(GERMAN_ID, B1_ID);
    public static final CvLanguageFormDTO GERMAN_B2 = new CvLanguageFormDTO(GERMAN_ID, B2_ID);

    public static final int ARMAND = 1;
    public static final int EMIE = 2;
    public static final int LEO = 3;
    public static final int PLINI = 4;

    // Formulaires de création de CV
    public static final CvFormDTO cv1 = new CvFormDTO(null, ARMAND, List.of(FRENCH_A1, ENGLISH_A1));
    public static final CvFormDTO cv2 = new CvFormDTO(null, EMIE, List.of(FRENCH_A2, ENGLISH_A2));
    public static final CvFormDTO cv3 = new CvFormDTO(null, LEO, List.of(FRENCH_B1, ENGLISH_B1));

    // Formulaires de modification de CV
    public static final CvFormDTO cv4 = new CvFormDTO(null, EMIE, List.of(FRENCH_B2, GERMAN_B2, ENGLISH_B2));

    // Modification du CV4
    public static final CvFormDTO cv4m = new CvFormDTO(4, EMIE, List.of(FRENCH_B1, ENGLISH_B1));

    // Création User, CV
    public static final User plini = User.builder()
                                         .name("plini")
                                         .build();

    public static final CvFormDTO cv5 = new CvFormDTO(null, PLINI, List.of(ENGLISH_B1));
    public static final CvFormDTO cv5m = new CvFormDTO(5, PLINI, List.of(ENGLISH_B2));

}
