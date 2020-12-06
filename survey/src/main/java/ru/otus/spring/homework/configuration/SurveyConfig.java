package ru.otus.spring.homework.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SurveyConfig {
    int numberOfQuestions;
    int numberOfRightAnswers;
    String fileName;
}
