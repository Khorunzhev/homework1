package ru.otus.spring.homework.model.enums;

public enum QuestionType {
    FREE_FORM("Print your answer in free-form"),
    MULTIPLE_CHOICE("Choose the correct answer from the proposed ones, than print it in the input field");

    private final String description;

    QuestionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
