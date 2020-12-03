package ru.otus.spring.homework.serivce.utils.exceptions;

public class ReadUserInformationException extends RuntimeException {
    public ReadUserInformationException(Exception e) {
        super(e);
    }
}
