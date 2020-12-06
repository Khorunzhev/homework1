package ru.otus.spring.homework.serivce.survey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;

import java.util.List;

@Service
public class SurveyCheckServiceImpl implements SurveyCheckService {

    private final SurveyConfig surveyConfig;
    private final AskQuestionService askQuestionService;
    private final AnswerCheckService answerCheckService;
    private final InteractWithUserService interactWithUserService;
    private final QuestionDao questionDao;

    @Autowired
    public SurveyCheckServiceImpl(SurveyConfig surveyConfig,
                                  AskQuestionService askQuestionService,
                                  AnswerCheckService answerCheckService,
                                  QuestionDao questionDao,
                                  InteractWithUserService interactWithUserService) {

        this.answerCheckService = answerCheckService;
        this.askQuestionService = askQuestionService;
        this.surveyConfig = surveyConfig;
        this.questionDao = questionDao;
        this.interactWithUserService = interactWithUserService;
    }

    @Override
    public boolean getSurveyResult() {
        return getResult(runSurvey());
    }

    private int runSurvey() {
        List<Question> questionList = questionDao.findAll();
        int numberOfRightAnswers = 0;

        for (Question question : questionList) {
            String actualAnswer = askQuestionService.askQuestion(question);
            if (answerCheckService.checkAnswer(question.getCorrectAnswer(), actualAnswer))
                numberOfRightAnswers++;
        }

        return numberOfRightAnswers;
    }

    private boolean getResult(int numberOfRightAnswers) {
        if (numberOfRightAnswers >= surveyConfig.getNumberOfRightAnswers()) {
            interactWithUserService.writeTo("Тест пройден");
            return true;
        } else {
            interactWithUserService.writeTo("Тест провален");
            return false;
        }
    }
}
