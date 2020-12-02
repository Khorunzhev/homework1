package ru.otus.spring.homework1.serivce;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.serivce.formatter.QuestionFormatterService;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class QuestionConsolePrintServiceImpl implements QuestionPrintService {

    private final QuestionFormatterService questionFormatterService;
    private final QuestionDao questionDao;

    @Override
    public void printAllQuestions() {
        List<Question> questionList = questionDao.findAll();
        for(Question question: questionList) {
            String questionString = questionFormatterService.formatQuestionAnswer(question);
            System.out.println(questionString);
        }
    }
}
