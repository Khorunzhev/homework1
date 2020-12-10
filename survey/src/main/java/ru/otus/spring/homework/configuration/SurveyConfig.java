package ru.otus.spring.homework.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@AllArgsConstructor
@Getter
@Setter
public class SurveyConfig {
    private int numberOfQuestions;
    private int numberOfRightAnswers;
    private Locale locale;
    private String fileName;
}
