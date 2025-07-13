package com.example.demo;

import com.example.demo.dto.CvLanguageFormDTO;


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

}
