package ru.otus.spring.homework1.dao.csv;

import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.dao.csv.utils.CsvToQuestionListParser;
import ru.otus.spring.homework1.model.Question;
import java.util.List;

public class QuestionDaoCSV implements QuestionDao {

    private final List<Question> questions;;

    public QuestionDaoCSV(CsvToQuestionListParser csvToQuestionListParser) {
        this.questions = csvToQuestionListParser.parseCsvToQuestionList();
    }

    @Override
    public List<Question> findAll() {
       return questions;
    }
}
