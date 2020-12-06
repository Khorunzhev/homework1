package ru.otus.spring.homework.serivce.answers;

public interface AnswerCheckService {

    boolean checkAnswer(String expectedAnswer, String actualAnswer);
}
