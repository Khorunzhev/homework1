package ru.otus.spring.homework1.serivce.questions;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.serivce.questions.formatter.QuestionFormatterService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Log
@Service
@AllArgsConstructor
public class AskQuestionConsoleServiceImpl implements AskQuestionService {

    private final QuestionFormatterService questionFormatterService;

    @SneakyThrows
    @Override
    public void printAllQuestions(List<Question> questionList) {
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            System.out.println(questionString);
        }
    }

    @SneakyThrows
    @Override
    public String askQuestion(Question question) {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String questionString = questionFormatterService.formatQuestionAnswer(question);
        System.out.println(questionString);
        return reader.readLine();

    }
}
