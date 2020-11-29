package ru.otus.spring.homework1.serivce;

import lombok.extern.java.Log;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.serivce.formatter.QuestionFormatterService;

import java.util.List;
import java.util.function.Supplier;

@Log
public class QuestionConsolePrintServiceImpl implements QuestionPrintService {

    QuestionFormatterService questionFormatterService;
    QuestionDao questionDao;

    public QuestionConsolePrintServiceImpl(QuestionDao questionDao,
                                           QuestionFormatterService questionFormatterService) {
        this.questionDao = questionDao;
        this.questionFormatterService = questionFormatterService;
    }

    @Override
    public void printAllQuestions() {
        List<Question> questionList = questionDao.findAll();
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            System.out.println(questionString);
        }
    }
}
