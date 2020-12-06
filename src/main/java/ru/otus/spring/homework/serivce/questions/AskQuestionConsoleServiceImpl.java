package ru.otus.spring.homework.serivce.questions;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.questions.formatter.QuestionFormatterService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class AskQuestionConsoleServiceImpl implements AskQuestionService {

    private final QuestionFormatterService questionFormatterService;
    private final InteractWithUserService interactWithUserService;

    @Override
    public void askAllQuestions(List<Question> questionList) {
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            interactWithUserService.writeTo(questionString);
        }
    }

    @Override
    public String askQuestion(Question question) {
        String questionString = questionFormatterService.formatQuestionAnswer(question);
        interactWithUserService.writeTo(questionString);
        return interactWithUserService.readFrom();

    }
}
