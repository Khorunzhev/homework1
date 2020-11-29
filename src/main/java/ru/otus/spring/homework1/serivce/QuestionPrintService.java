package ru.otus.spring.homework1.serivce;

import lombok.extern.java.Log;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;

import java.util.List;

public interface QuestionPrintService {

    public void printAllQuestions();
}
