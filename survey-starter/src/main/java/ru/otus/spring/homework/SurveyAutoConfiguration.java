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

        log.info(String.format(
                "AutoConfig. creating SurveyConfig " +
                "with numberOfQuestions = %d, numberOfRightAnswers = %d, locale = %s and fileName = %s",
                surveyProps.getNumberOfQuestions(),
                surveyProps.getNumberOfRightAnswers(),
                surveyProps.getLocale(),
                surveyProps.getFileName()));

        return new SurveyConfig(
                surveyProps.getNumberOfQuestions(),
                surveyProps.getNumberOfRightAnswers(),
                surveyProps.getLocale(),
                surveyProps.getFileName());
    }

}
