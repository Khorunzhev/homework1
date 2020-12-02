package ru.otus.spring.homework1.dao.csv.utils;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.homework1.model.FreeFormQuestion;
import ru.otus.spring.homework1.model.MultipleChoiceQuestion;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.model.enums.QuestionType;
import ru.otus.spring.homework1.model.enums.SurveyCSVHeaders;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Log
public class CsvToQuestionListParser {

    public static final int ANSWER_COLUMN_BEGIN_FROM_POSITION = 4;

    private final CsvReader csvReader;

    public CsvToQuestionListParser(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @SneakyThrows
    public List<Question> parseCsvToQuestionList() {

        Path csvFile = csvReader.getCsvPathFromResource();

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(SurveyCSVHeaders.class)
                .withFirstRecordAsHeader()
                .parse(Files.newBufferedReader(csvFile));

        return getQuestionList(records);

    }

    private List<Question> getQuestionList(Iterable<CSVRecord> records) {
        List<Question> questionList = new ArrayList<>();
        for (CSVRecord record : records) {
            String questionType = record.get(SurveyCSVHeaders.QuestionType).toUpperCase();
            switch (QuestionType.valueOf(questionType)) {
                case MULTIPLE_CHOICE:
                    questionList.add(getMultipleQuestion(record));
                    break;
                case FREE_FORM:
                    questionList.add(getFreeFormQuestion(record));
                    break;
                default:
                    log.info(String.format("Не распознан формат вопроса. Приложение не поддерживает формат %s", questionType));
                    break;
            }
        }
        return questionList;
    }

    private Question getMultipleQuestion(CSVRecord record) {
        List<String> answers = new ArrayList<>();
        int numberOfAnswers = Integer.parseInt(record.get(SurveyCSVHeaders.NumberOfAnswers));
        int asnwerColumntStartPosition = ANSWER_COLUMN_BEGIN_FROM_POSITION;
        while (numberOfAnswers > 0) {
            answers.add(record.get(asnwerColumntStartPosition));
            numberOfAnswers--;
            asnwerColumntStartPosition++;
        }
        return MultipleChoiceQuestion
                .builder()
                .questionText(record.get(SurveyCSVHeaders.Question))
                .questionDescription(QuestionType.MULTIPLE_CHOICE.getDescription())
                .answers(answers)
                .build();
    }

    private Question getFreeFormQuestion(CSVRecord record) {
        return FreeFormQuestion
                .builder()
                .questionText(record.get(SurveyCSVHeaders.Question))
                .questionDescription(QuestionType.FREE_FORM.getDescription())
                .build();
    }
}
