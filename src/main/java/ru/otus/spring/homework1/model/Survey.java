package ru.otus.spring.homework1.model;

import lombok.Data;

import java.util.List;

@Data
public class Survey {
    private List<Question> questions;
}
