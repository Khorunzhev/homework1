package ru.otus.spring.homework.dao;

import ru.otus.spring.homework.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> findAll();

}
