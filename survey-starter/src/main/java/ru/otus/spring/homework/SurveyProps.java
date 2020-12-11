package ru.otus.spring.homework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix="survey")
@Data
public class SurveyProps {

    private int numberOfQuestions = getDefaultNumberOfQuestions();
    private int numberOfRightAnswers = getDefaultNumberOfRightAnswers();
    private Locale locale = getDefaultLocale();
    private String fileName = getDefaultFile();

    private int getDefaultNumberOfQuestions() {
        return 5;
    }

    private int getDefaultNumberOfRightAnswers() {
        return 1;
    }

    private Locale getDefaultLocale() {
        return Locale.ENGLISH;
    }

    private String getDefaultFile() {
        return "questions_en.csv";
    }
}
