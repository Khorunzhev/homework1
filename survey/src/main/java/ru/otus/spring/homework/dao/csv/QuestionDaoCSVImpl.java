package ru.otus.spring.homework.dao.csv;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.dao.csv.utils.CsvToQuestionListParser;
import ru.otus.spring.homework.model.Question;
import java.util.List;

@Repository
@AllArgsConstructor
public class QuestionDaoCSVImpl implements QuestionDao {

    private final CsvToQuestionListParser csvToQuestionListParser;
    private final SurveyConfig surveyConfig;

    @Override
    public List<Question> findAll() {
        return csvToQuestionListParser.parseCsvToQuestionList(getCsvFileName());
    }

    private String getCsvFileName() {
       return surveyConfig.getFileName();
    }
}
