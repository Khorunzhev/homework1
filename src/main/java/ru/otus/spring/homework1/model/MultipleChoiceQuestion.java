package ru.otus.spring.homework1.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@SuperBuilder
public class MultipleChoiceQuestion extends Question {
    private final List<String> answers;
}
