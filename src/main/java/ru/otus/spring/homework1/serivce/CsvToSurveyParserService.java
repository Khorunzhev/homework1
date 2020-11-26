package ru.otus.spring.homework1.serivce;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.homework1.model.Survey;
import ru.otus.spring.homework1.model.enums.SurveyCSVHeaders;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

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
            String
        }
    }

}
