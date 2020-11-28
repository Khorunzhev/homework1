package ru.otus.spring.homework1.serivce;

import lombok.extern.java.Log;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;

import java.util.List;
import java.util.function.Supplier;

@Log
public class QuestionConsolePrintServiceImpl implements QuestionPrintService {

    private final QuestionDao questionDao;

    public QuestionConsolePrintServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    @Override
    public String printAllQuestions() {
        List<Question> questionList = questionDao.findAll();

        for(Question question: questionList) {
            
        }
    }
}
