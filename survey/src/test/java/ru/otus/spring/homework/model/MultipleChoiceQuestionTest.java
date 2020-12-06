package ru.otus.spring.homework.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("MultipleChoiceQuestionTest")
public class MultipleChoiceQuestionTest {

    @DisplayName("Проверка работы builder")
    @Test
    public void shouldHaveCorrectBuilder() {

        MultipleChoiceQuestion question = MultipleChoiceQuestion.builder()
                .questionText("Question")
                .questionDescription("Description")
                .answers(Arrays.asList("Ответ1", "Ответ2"))
                .build();

        Assertions.assertEquals("Question", question.getQuestionText());
        Assertions.assertEquals("Description", question.getQuestionDescription());
        Assertions.assertEquals(Arrays.asList("Ответ1", "Ответ2"), question.getAnswers());

    }
}
