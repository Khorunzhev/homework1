package ru.otus.spring.homework1.dao.csv;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionDaoCSVImpl implements QuestionDao {

    private final List<Question> questions;;

    @Override
    public List<Question> findAll() {
       return questions;
    }
}
