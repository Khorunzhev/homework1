package ru.otus.spring.homework.dao.csv.utils.exceptions;

public class CSVParsingException extends RuntimeException {
    public CSVParsingException(Exception e) {
        super(e);
    }
}
