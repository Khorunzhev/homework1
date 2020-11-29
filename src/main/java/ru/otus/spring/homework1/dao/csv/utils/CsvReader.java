package ru.otus.spring.homework1.dao.csv.utils;


import lombok.SneakyThrows;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvReader {

    private final String fileName;

    public CsvReader(String fileName) {
        this.fileName = fileName;
    }

    @SneakyThrows
    public Path getCsvPathFromResource() {
        URL csvFile = getClass().getClassLoader().getResource(fileName);
        return Paths.get(csvFile.toURI());
    }

}
