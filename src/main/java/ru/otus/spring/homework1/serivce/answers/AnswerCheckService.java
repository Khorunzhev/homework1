package ru.otus.spring.homework1.serivce.answers;

public interface AnswerCheckService {

    boolean checkAnswer(String expectedAnswer, String actualAnswer);
}
