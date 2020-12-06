package ru.otus.spring.homework;

import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.homework.configuration.SurveyConfig;

@Configuration
@ConditionalOnClass(SurveyConfig.class)
@EnableConfigurationProperties(SurveyProps.class)
@Log
public class SurveyAutoConfiguration {

    private final SurveyProps surveyProps;

    public SurveyAutoConfiguration(SurveyProps surveyProps) {
        this.surveyProps = surveyProps;
    }

    @Bean
    @ConditionalOnMissingBean
    public SurveyConfig surveyConfig() {
        int defaultNumberOfQuestions = 5;
        int defaultNumberOfRightAnswers = 1;
        int numberOfQuestions = surveyProps.getNumberOfQuestions() == 0 ? defaultNumberOfQuestions : surveyProps.getNumberOfQuestions();
        int numberOfRightAnswers = surveyProps.getNumberOfRightAnswers() == 0 ? defaultNumberOfRightAnswers : surveyProps.getNumberOfRightAnswers();
        log.info(String.format(
                "AutoConfig. creating SurveyConfig " +
                "with numberOfQuestions = %d, numberOfRightAnswers = %d",
                numberOfQuestions,
                numberOfRightAnswers));
        return new SurveyConfig(numberOfQuestions, numberOfRightAnswers);
    }

}
