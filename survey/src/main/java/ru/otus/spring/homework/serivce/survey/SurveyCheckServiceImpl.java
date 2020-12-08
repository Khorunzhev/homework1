package ru.otus.spring.homework.serivce.survey;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework.serivce.utils.UserCommuncationService;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyCheckServiceImpl implements SurveyCheckService {

    private final SurveyConfig surveyConfig;
    private final AskQuestionService askQuestionService;
    private final AnswerCheckService answerCheckService;
    private final QuestionDao questionDao;
    private final UserCommuncationService userCommuncationService;

    @Override
    public boolean getSurveyResult() {
        return getResult(runSurvey());
    }

    private int runSurvey() {
        List<Question> questionList = questionDao.findAll();
        int numberOfRightAnswers = 0;

        String userName = userCommuncationService.askUserName();
        userCommuncationService.sayWelcomeToUser(userName);

        for (Question question : questionList) {
            String actualAnswer = askQuestionService.askQuestion(question);
            if (answerCheckService.checkAnswer(question.getCorrectAnswer(), actualAnswer))
                numberOfRightAnswers++;
        }

        return numberOfRightAnswers;
    }

    private boolean getResult(int numberOfRightAnswers) {
        if (numberOfRightAnswers >= surveyConfig.getNumberOfRightAnswers()) {
            userCommuncationService.sayTestPassed();
            return true;
        } else {
            userCommuncationService.sayTestFailed();
            return false;
        }
    }
}
