package ru.otus.spring.homework.dao.csv.utils;


import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileReader {

    @SneakyThrows
    public Path getPathFromResource(String fileName) {
        URL csvFile = getClass().getClassLoader().getResource(fileName);
        return Paths.get(csvFile.toURI());
    }

}
