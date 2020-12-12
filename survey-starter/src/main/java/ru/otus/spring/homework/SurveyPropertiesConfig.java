package ru.otus.spring.homework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.otus.spring.homework.configuration.SurveyConfig;

import java.util.Locale;

@ConfigurationProperties(prefix="survey")
@Data
public class SurveyPropertiesConfig {

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
