package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
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
import ru.otus.spring.homework.serivce.utils.UserCommuncationService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class SurveyCheckServiceImplTest {

    private SurveyCheckService surveyCheckServiceImpl;

    @Mock
    private AskQuestionService askQuestionService;
    @Mock
    private AnswerCheckService answerCheckService;
    @Mock
    private UserCommuncationService userCommuncationService;
    @Mock
    private QuestionDao questionDao;
    @Mock
    private  SurveyConfig surveyConfig;



    @BeforeEach
    public void initMocks() {
        surveyCheckServiceImpl = new SurveyCheckServiceImpl(
                surveyConfig,
                askQuestionService,
                answerCheckService,
                questionDao,
                userCommuncationService);
    }


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

        Assertions.assertFalse(surveyCheckServiceImpl.getSurveyResult());

    }
}
