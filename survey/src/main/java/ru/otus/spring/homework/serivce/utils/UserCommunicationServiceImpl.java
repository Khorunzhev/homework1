package ru.otus.spring.homework.serivce.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

@Service
@AllArgsConstructor
public class UserCommunicationServiceImpl implements UserCommuncationService {

    private final InteractWithUserService interactWithUserService;
    private final LocalizationService localizationService;


    @Override
    public String askUserName() {
        interactWithUserService.writeTo(localizationService.getLocalizationString("user.hello"));
        return interactWithUserService.readFrom();
    }

    @Override
    public void sayWelcomeToUser(String userName) {
        interactWithUserService.writeTo(localizationService.getLocalizationString("user.greeting", new Object[] {userName}));
    }

    @Override
    public void sayTestPassed() {
        interactWithUserService.writeTo(localizationService.getLocalizationString("user.test.passed"));
    }

    @Override
    public void sayTestFailed() {
        interactWithUserService.writeTo(localizationService.getLocalizationString("user.test.failed"));
    }
}
