package ru.otus.spring.homework.serivce.utils;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;

@Service
@AllArgsConstructor
public class UserCommunicationServiceImpl implements UserCommuncationService {

    InteractWithUserService interactWithUserService;
    MessageSource messageSource;
    SurveyConfig surveyConfig;


    @Override
    public void sayHelloToUser() {
        interactWithUserService.writeTo(messageSource.getMessage("user.hello", null, surveyConfig.getLocale()));
    }

    @Override
    public void sayTestPassed() {
        interactWithUserService.writeTo(messageSource.getMessage("user.test.passed",null, surveyConfig.getLocale()));
    }

    @Override
    public void sayTestFailed() {
        interactWithUserService.writeTo(messageSource.getMessage("user.test.failed", null, surveyConfig.getLocale()));
    }
}
