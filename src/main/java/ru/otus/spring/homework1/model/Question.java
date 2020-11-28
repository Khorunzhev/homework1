package ru.otus.spring.homework1.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.otus.spring.homework1.model.enums.QuestionType;

@Getter
@SuperBuilder
public class Question {

    private final String correctAnswer;
    private final String questionText;
    private final String questionDescription;

}
