package ru.otus.spring.homework1.serivce.formatter;

import ru.otus.spring.homework1.model.FreeFormQuestion;
import ru.otus.spring.homework1.model.MultipleChoiceQuestion;
import ru.otus.spring.homework1.model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionFormatterService {

    private static final String MULTIPLE_ANSWERS_QUESTION_FORMATIVE_STRING =
            "Вопрос: %s \n Тип вопроса: %s \n Возможные ответы: %s \n Ваш ответ: ";
    private static final String FREE_FORM_QUESTION_FORMATIVE_STRING =
            "Вопрос: %s \n Тип вопроса: %s \n Ваш ответ: ";

    public String formatQuestionAnswer(Question question) {
        if (question instanceof MultipleChoiceQuestion) {
            return String.format(MULTIPLE_ANSWERS_QUESTION_FORMATIVE_STRING,
                    question.getQuestionText(),
                    question.getQuestionDescription(),
                    formatMultipleAnswers(((MultipleChoiceQuestion) question).getAnswers()));
        } else if (question instanceof FreeFormQuestion) {
            return String.format(FREE_FORM_QUESTION_FORMATIVE_STRING,
                    question.getQuestionText(),
                    question.getQuestionDescription());
        } else {
            return "Передан неверный тип вопроса";
        }
    }

    private String formatMultipleAnswers(List<String> answers) {
        return answers.stream()
                .map(string -> String.format("%s,", string))
                .collect(Collectors.joining());
    }
}
