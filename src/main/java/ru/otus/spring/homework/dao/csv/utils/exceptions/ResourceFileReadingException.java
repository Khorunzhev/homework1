package ru.otus.spring.homework.dao.csv.utils.exceptions;

public class ResourceFileReadingException extends RuntimeException {
    public ResourceFileReadingException(Exception e) {
        super(e);
    }
}
