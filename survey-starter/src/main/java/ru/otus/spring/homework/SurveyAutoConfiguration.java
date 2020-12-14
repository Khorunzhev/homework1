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
@EnableConfigurationProperties(SurveyPropertiesConfig.class)
@Log
public class SurveyAutoConfiguration {

    private final SurveyPropertiesConfig surveyPropertiesConfig;

    public SurveyAutoConfiguration(SurveyPropertiesConfig surveyPropertiesConfig) {
        this.surveyPropertiesConfig = surveyPropertiesConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public SurveyConfig surveyConfig() {

        log.info(String.format(
                "AutoConfig. creating SurveyConfig " +
                "with numberOfQuestions = %d, numberOfRightAnswers = %d, locale = %s and fileName = %s",
                surveyPropertiesConfig.getNumberOfQuestions(),
                surveyPropertiesConfig.getNumberOfRightAnswers(),
                surveyPropertiesConfig.getLocale(),
                surveyPropertiesConfig.getFileName()));

        return new SurveyConfig(
                surveyPropertiesConfig.getNumberOfQuestions(),
                surveyPropertiesConfig.getNumberOfRightAnswers(),
                surveyPropertiesConfig.getLocale(),
                surveyPropertiesConfig.getFileName());
    }

}
