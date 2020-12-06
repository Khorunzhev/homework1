package ru.otus.spring.homework.dao.csv.utils;


import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.otus.spring.homework.dao.csv.utils.exceptions.ResourceFileReadingException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileReader {

    public Path getPathFromResource(String fileName) {
        URL csvFile = getClass().getClassLoader().getResource(fileName);
        try {
            return Paths.get(csvFile.toURI());
        } catch (URISyntaxException e) {
            throw new ResourceFileReadingException(e);
        }
    }
}
