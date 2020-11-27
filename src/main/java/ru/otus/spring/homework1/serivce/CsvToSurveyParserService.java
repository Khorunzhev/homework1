package ru.otus.spring.homework1.serivce;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.homework1.model.FreeFormQuestion;
import ru.otus.spring.homework1.model.MultipleChoiceQuestion;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.model.Survey;
import ru.otus.spring.homework1.model.enums.QuestionType;
import ru.otus.spring.homework1.model.enums.SurveyCSVHeaders;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Log
public class CsvToSurveyParserService {

    private CsvReaderService csvReaderService;

    @SneakyThrows
    public Survey parseCsvToSurvey(String fileName) {
        Path csvFile = csvReaderService.getCsvPathFromResource(fileName);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(SurveyCSVHeaders.class)
                .withFirstRecordAsHeader()
                .parse(Files.newBufferedReader(csvFile));

        for (CSVRecord record : records) {
            Question question;
            switch (QuestionType.valueOf(record.get(SurveyCSVHeaders.QuestionType).toUpperCase())) {
                case MULTIPLE_CHOICE:
                    List<String> answers = new ArrayList<>();
                    int numberOfAnswers = Integer.parseInt(record.get(SurveyCSVHeaders.NumberOfAnswers));
                    while (numberOfAnswers>0) {
                        answers.add(record.get(4));
                        numberOfAnswers--;
                    }
                    question = MultipleChoiceQuestion
                            .builder()
                            .questionText(record.get(SurveyCSVHeaders.Question))
                            .questionDescription(QuestionType.MULTIPLE_CHOICE.getDescription())
                            .answers(answers)
                            .build();
                    break;
        }
    }

}
