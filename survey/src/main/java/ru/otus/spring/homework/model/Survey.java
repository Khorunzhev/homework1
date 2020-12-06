package ru.otus.spring.homework.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Survey {
    private final List<Question> questions;
}
