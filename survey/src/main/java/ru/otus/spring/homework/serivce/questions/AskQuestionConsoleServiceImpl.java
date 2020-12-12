package ru.otus.spring.homework.serivce.questions;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.questions.formatter.QuestionFormatterService;
import ru.otus.spring.homework.serivce.utils.InputOutputWrapper;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class AskQuestionConsoleServiceImpl implements AskQuestionService {

    private final QuestionFormatterService questionFormatterService;
    private final InputOutputWrapper inputOutputWrapper;

    @Override
    public void askAllQuestions(List<Question> questionList) {
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            inputOutputWrapper.writeTo(questionString);
        }
    }

    @Override
    public String askQuestion(Question question) {
        String questionString = questionFormatterService.formatQuestionAnswer(question);
        inputOutputWrapper.writeTo(questionString);
        return inputOutputWrapper.readFrom();

    }
}
