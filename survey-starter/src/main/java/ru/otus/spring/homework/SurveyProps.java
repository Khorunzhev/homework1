package ru.otus.spring.homework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="survey")
@Data
public class SurveyProps {

    private int numberOfQuestions;
    private int numberOfRightAnswers;
    private String fileQuestions;

}
