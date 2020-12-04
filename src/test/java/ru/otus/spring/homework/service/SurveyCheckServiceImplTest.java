package ru.otus.spring.homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.homework.dao.QuestionDao;
import ru.otus.spring.homework.model.MultipleChoiceQuestion;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.answers.AnswerCheckService;
import ru.otus.spring.homework.serivce.questions.AskQuestionService;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;
import ru.otus.spring.homework.serivce.survey.SurveyCheckServiceImpl;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DisplayName("SurveyCheckServiceImpl")
@ExtendWith(MockitoExtension.class)
public class SurveyCheckServiceImplTest {

    private SurveyCheckService surveyCheckServiceImpl;

    @Mock
    private AskQuestionService askQuestionService;
    @Mock
    private AnswerCheckService answerCheckService;
    @Mock
    private InteractWithUserService interactWithUserService;
    @Mock
    private QuestionDao questionDao;

    Integer numberOfRightAnswers;


    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        numberOfRightAnswers = 1;
        surveyCheckServiceImpl = new SurveyCheckServiceImpl(
                numberOfRightAnswers,
                askQuestionService,
                answerCheckService,
                questionDao,
                interactWithUserService);
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
