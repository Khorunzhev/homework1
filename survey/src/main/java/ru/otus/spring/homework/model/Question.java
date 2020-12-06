package ru.otus.spring.homework.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Question {

    private final String correctAnswer;
    private final String questionText;
    private final String questionDescription;

}
