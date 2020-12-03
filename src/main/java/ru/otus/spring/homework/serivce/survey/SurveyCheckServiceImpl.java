package ru.otus.spring.homework.serivce.survey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;

import java.util.List;

@Service
public class SurveyCheckServiceImpl implements SurveyCheckService {

    private final Integer expectedNumberOfRightAnswers;
    private final AskQuestionService askQuestionService;
    private final AnswerCheckService answerCheckService;
    private final InteractWithUserService interactWithUserService;
    private final QuestionDao questionDao;

    @Autowired
    public SurveyCheckServiceImpl(@Value("${survey.answers.positive}") Integer expectedNumberOfRightAnswers,
                                  AskQuestionService askQuestionService,
                                  AnswerCheckService answerCheckService,
                                  QuestionDao questionDao,
                                  InteractWithUserService interactWithUserService) {

        this.answerCheckService = answerCheckService;
        this.askQuestionService = askQuestionService;
        this.expectedNumberOfRightAnswers = expectedNumberOfRightAnswers;
        this.questionDao = questionDao;
        this.interactWithUserService = interactWithUserService;
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
            interactWithUserService.writeTo("Тест пройден");
        } else {
            interactWithUserService.writeTo("Тест провален");
        }

    }
}
