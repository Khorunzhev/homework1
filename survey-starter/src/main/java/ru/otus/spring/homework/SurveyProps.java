package ru.otus.spring.homework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix="survey")
@Data
public class SurveyProps {

    private int numberOfQuestions;
    private int numberOfRightAnswers;
    private Locale locale;
    private String fileName;


    public int getNumberOfQuestions() {
        if (numberOfQuestions != 0) {
            return numberOfQuestions;
        } else {
            return getDefaultNumberOfQuestions();
        }
    }

    private int getDefaultNumberOfQuestions() {
        return 5;
    }

    public int getNumberOfRightAnswers() {
        if (numberOfRightAnswers != 0) {
            return numberOfRightAnswers;
        } else {
            return getDefaultNumberOfRightAnswers();
        }
    }

    private int getDefaultNumberOfRightAnswers() {
        return 1;
    }

    public Locale getLocale() {
        if (locale != null) {
            return locale;
        } else {
            return getDefaultLocale();
        }
    }

    private Locale getDefaultLocale() {
        return Locale.ENGLISH;
    }

    public String getFileName() {
        if (fileName != null) {
            return fileName;
        } else {
            return getDefaultFile();
        }
    }

    private String getDefaultFile() {
        return "questions_en.csv";
    }
}
