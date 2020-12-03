package ru.otus.spring.homework1.serivce.questions;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.serivce.questions.formatter.QuestionFormatterService;
import ru.otus.spring.homework1.serivce.utils.InteractWithUserService;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class AskQuestionConsoleServiceImpl implements AskQuestionService {

    private final QuestionFormatterService questionFormatterService;
    private final InteractWithUserService interactWithUserService;

    @SneakyThrows
    @Override
    public void askAllQuestions(List<Question> questionList) {
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            interactWithUserService.writeTo(questionString);
        }
    }

    @SneakyThrows
    @Override
    public String askQuestion(Question question) {
        String questionString = questionFormatterService.formatQuestionAnswer(question);
        interactWithUserService.writeTo(questionString);
        return interactWithUserService.readFrom();

    }
}
