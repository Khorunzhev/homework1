package ru.otus.spring.homework1.serivce.survey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework1.dao.QuestionDao;
import ru.otus.spring.homework1.model.Question;
import ru.otus.spring.homework1.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework1.serivce.questions.AskQuestionService;

import java.util.List;

@Service
public class SurveyCheckServiceImpl implements SurveyCheckService {

    private final Integer expectedNumberOfRightAnswers;
    private final AskQuestionService askQuestionService;
    private final AnswerCheckService answerCheckService;
    private final QuestionDao questionDao;

    @Autowired
    public SurveyCheckServiceImpl(@Value("${survey.answers.positive}") Integer expectedNumberOfRightAnswers,
                                  AskQuestionService askQuestionService,
                                  AnswerCheckService answerCheckService,
                                  QuestionDao questionDao) {

        this.answerCheckService = answerCheckService;
        this.askQuestionService = askQuestionService;
        this.expectedNumberOfRightAnswers = expectedNumberOfRightAnswers;
        this.questionDao = questionDao;
    }

    @Override
    public void runSurvey() {
        List<Question> questionList = questionDao.findAll();
        int numberOfRightAnswers = 0;

        for (Question question : questionList) {
            String actualAnswer = askQuestionService.askQuestion(question);
            if (answerCheckService.checkAnswer(actualAnswer, question.getCorrectAnswer()))
                numberOfRightAnswers++;
        }

        if (numberOfRightAnswers >= expectedNumberOfRightAnswers) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест провален");
        }

    }
}
