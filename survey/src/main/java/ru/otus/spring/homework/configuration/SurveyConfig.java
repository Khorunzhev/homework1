package ru.otus.spring.homework.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Locale;

@AllArgsConstructor
@Getter
public class SurveyConfig {
    int numberOfQuestions;
    int numberOfRightAnswers;
    Locale locale;
}
