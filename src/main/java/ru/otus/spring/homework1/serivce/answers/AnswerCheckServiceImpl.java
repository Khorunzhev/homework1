package ru.otus.spring.homework1.serivce.answers;

import org.springframework.stereotype.Service;

@Service
public class AnswerCheckServiceImpl implements AnswerCheckService {

    @Override
    public boolean checkAnswer(String expectedAnswer, String actualAnswer) {
        return expectedAnswer.equals(actualAnswer);
    }
}
