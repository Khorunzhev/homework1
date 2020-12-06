package ru.otus.spring.homework.dao.csv.utils;


import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileReader {

    @SneakyThrows
    public Path getPathFromResource(String fileName) {
        URL csvFile = getClass().getClassLoader().getResource(fileName);
        return Paths.get(csvFile.toURI());
    }

}
