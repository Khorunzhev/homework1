package ru.otus.spring.homework1.model.enums;

public enum QuestionType {
    FREE_FORM("Напечатайте ответ в свободной форме"),
    MULTIPLE_CHOICE("Выберите правильный ответ из предложенных, для этого напечатайте его в поле ввода");

    private String description;

    QuestionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
