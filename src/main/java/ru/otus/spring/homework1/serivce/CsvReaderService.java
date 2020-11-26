package ru.otus.spring.homework1.serivce;


import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvReaderService {


    @SneakyThrows
    public Path getCsvPathFromResource(String fileName) {
        URL csvFile = getClass().getResource(fileName);
        return Paths.get(csvFile.toURI());
    }

}
