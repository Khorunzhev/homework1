package ru.otus.spring.homework.dao.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.dao.csv.utils.CsvToQuestionListParser;
import ru.otus.spring.homework.model.Question;
import java.util.List;

@Repository
public class QuestionDaoCSVImpl implements QuestionDao {

    private final CsvToQuestionListParser csvToQuestionListParser;
    private final String csvFileName;

    @Autowired
    public QuestionDaoCSVImpl(@Value("${survey.questions.source.filename}") String csvFile,
                              CsvToQuestionListParser csvToQuestionListParser) {
        this.csvToQuestionListParser = csvToQuestionListParser;
        this.csvFileName = csvFile;
    }

    @Override
    public List<Question> findAll() {
        return csvToQuestionListParser.parseCsvToQuestionList(csvFileName);
    }
}
