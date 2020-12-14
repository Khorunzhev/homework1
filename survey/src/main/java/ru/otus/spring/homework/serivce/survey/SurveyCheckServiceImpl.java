package ru.otus.spring.homework.serivce.survey;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.utils.UserCommuncationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyCheckServiceImpl implements SurveyCheckService {

    private final SurveyConfig surveyConfig;
    private final AskQuestionService askQuestionService;
    private final AnswerCheckService answerCheckService;
    private final QuestionDao questionDao;
    private final UserCommuncationService userCommuncationService;

    private int numberOfRightAnswers;

    private boolean isTestPassed() {
        if (numberOfRightAnswers >= surveyConfig.getNumberOfRightAnswers()) {
            userCommuncationService.sayTestPassed();
            return true;
        } else {
            userCommuncationService.sayTestFailed();
            return false;
        }
    }

    @Override
    public boolean getSurveyResult() {
        List<Question> questionList = questionDao.findAll();
        numberOfRightAnswers = 0;

        String userName = userCommuncationService.askUserName();
        userCommuncationService.sayWelcomeToUser(userName);

        for (Question question : questionList) {
            String actualAnswer = askQuestionService.askQuestion(question);
            if (answerCheckService.checkAnswer(question.getCorrectAnswer(), actualAnswer))
                numberOfRightAnswers++;
        }
        return isTestPassed();
    }

    @Override
    public int getNumberOfRightAnswers() {
        return numberOfRightAnswers;
    }
}
