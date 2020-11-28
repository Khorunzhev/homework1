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

    public static final int ANSWER_COLUMN_BEGIN_FROM_POSITION = 4;

    @SneakyThrows
    public Survey parseCsvToSurvey(String fileName) {

        Path csvFile = csvReaderService.getCsvPathFromResource(fileName);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(SurveyCSVHeaders.class)
                .withFirstRecordAsHeader()
                .parse(Files.newBufferedReader(csvFile));


        List<Question> questionList;
        for (CSVRecord record : records) {
            Question question;
            switch (QuestionType.valueOf(record.get(SurveyCSVHeaders.QuestionType).toUpperCase())) {
                case MULTIPLE_CHOICE:
                    List<String> answers = new ArrayList<>();
                    int numberOfAnswers = Integer.parseInt(record.get(SurveyCSVHeaders.NumberOfAnswers));
                    int asnwerColumntStartPosition = ANSWER_COLUMN_BEGIN_FROM_POSITION;
                    while (numberOfAnswers > 0) {
                        answers.add(record.get(asnwerColumntStartPosition));
                        numberOfAnswers--;
                        asnwerColumntStartPosition++;
                    }
                    question = MultipleChoiceQuestion
                            .builder()
                            .questionText(record.get(SurveyCSVHeaders.Question))
                            .questionDescription(QuestionType.MULTIPLE_CHOICE.getDescription())
                            .answers(answers)
                            .build();

                    questionList.add(question);
                    break;
                case FREE_FORM:
                    question = FreeFormQuestion
                            .builder()
                            .questionText(record.get(SurveyCSVHeaders.Question))
                            .questionDescription(QuestionType.FREE_FORM.getDescription())
                            .build();

                    questionList.add(question);
                    break;
            }
        }

        return Survey.builder().

    }
}
