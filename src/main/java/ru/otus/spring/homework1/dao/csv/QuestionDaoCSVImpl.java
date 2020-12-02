package ru.otus.spring.homework1.dao.csv;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.dao.csv.utils.CsvToQuestionListParserService;
import ru.otus.spring.homework1.model.Question;
import java.util.List;

@Service
public class QuestionDaoCSVImpl implements QuestionDao {

    private final CsvToQuestionListParserService csvToQuestionListParserService;
    private final String csvFileName;

    @Autowired
    public QuestionDaoCSVImpl(@Value("${survey.questions.source.filename}") String csvFile,
                              CsvToQuestionListParserService csvToQuestionListParserService) {
        this.csvToQuestionListParserService = csvToQuestionListParserService;
        this.csvFileName = csvFile;
    }

    @Override
    public List<Question> findAll() {
        return csvToQuestionListParserService.parseCsvToQuestionList(csvFileName);
    }
}
