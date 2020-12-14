package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.MultipleChoiceQuestion;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;
import ru.otus.spring.homework.serivce.survey.SurveyCheckServiceImpl;
import ru.otus.spring.homework.serivce.utils.InputOutputWrapper;
import ru.otus.spring.homework.serivce.utils.InputOutputWrapperImpl;
import ru.otus.spring.homework.serivce.utils.UserCommuncationService;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class SurveyCheckServiceImplTest {


    @Autowired
    private SurveyCheckServiceImpl surveyCheckServiceImpl;

    @MockBean
    private AskQuestionService askQuestionService;
    @MockBean
    private AnswerCheckService answerCheckService;
    @MockBean
    private UserCommuncationService userCommuncationService;
    @MockBean
    private QuestionDao questionDao;
    @MockBean
    private  SurveyConfig surveyConfig;



    @Test
    public void checkPositiveSurveyRun(){
        Question question = MultipleChoiceQuestion.builder()
                .questionText("Question")
                .questionDescription("Description")
                .correctAnswer("Ответ1")
                .answers(Arrays.asList("Ответ1", "Ответ2"))
                .build();
        List<Question> questionList = Collections.singletonList(question);

        String userAnswer = "Ответ1";

        Mockito.doReturn(questionList).when(questionDao).findAll();
        Mockito.doReturn(userAnswer).when(askQuestionService).askQuestion(question);
        Mockito.doReturn(true).when(answerCheckService).checkAnswer(question.getCorrectAnswer(), userAnswer);
        Mockito.doReturn(1).when(surveyConfig).getNumberOfRightAnswers();
        Mockito.doReturn("TestName").when(userCommuncationService).askUserName();
        Mockito.doNothing().when(userCommuncationService).sayWelcomeToUser(Mockito.anyString());

        Assertions.assertTrue(surveyCheckServiceImpl.getSurveyResult());

    }

    @Test
    public void checkNegativeSurveyRun(){
        Question question = MultipleChoiceQuestion.builder()
                .questionText("Question")
                .questionDescription("Description")
                .correctAnswer("Ответ1")
                .answers(Arrays.asList("Ответ1", "Ответ2"))
                .build();
        List<Question> questionList = Collections.singletonList(question);

        String userAnswer = "Ответ2";

        Mockito.doReturn(questionList).when(questionDao).findAll();
        Mockito.doReturn(userAnswer).when(askQuestionService).askQuestion(question);
        Mockito.doReturn(false).when(answerCheckService).checkAnswer(question.getCorrectAnswer(), userAnswer);
        Mockito.doReturn(1).when(surveyConfig).getNumberOfRightAnswers();
        Mockito.doReturn("TestName").when(userCommuncationService).askUserName();
        Mockito.doNothing().when(userCommuncationService).sayWelcomeToUser(Mockito.anyString());

        Assertions.assertFalse(surveyCheckServiceImpl.getSurveyResult());

    }
}
