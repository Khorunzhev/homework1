package ru.otus.spring.homework.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class FreeFormQuestion extends Question {

    private final String answer;

}
