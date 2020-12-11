package ru.otus.spring.homework.serivce.utils;

public interface InteractWithUserService {

    String askUser();
    void sayToUser(String message, String... values);
}
