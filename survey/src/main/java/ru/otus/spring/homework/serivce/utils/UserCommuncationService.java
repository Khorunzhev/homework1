package ru.otus.spring.homework.serivce.utils;

public interface UserCommuncationService {

    String askUserName();
    void sayWelcomeToUser(String userName);
    void sayTestPassed();
    void sayTestFailed();

}
