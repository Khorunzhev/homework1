package ru.otus.spring.homework.serivce.questions;

import ru.otus.spring.homework.model.Question;

import java.util.List;

public interface AskQuestionService {

    void askAllQuestions(List<Question> questionList);
    String askQuestion(Question question);
}
