package ru.otus.spring.homework.serivce.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

@Service
@AllArgsConstructor
public class UserCommunicationServiceImpl implements UserCommuncationService {

    private final InteractWithUserService interactWithUserService;


    @Override
    public String askUserName() {
        interactWithUserService.sayToUser("user.hello");
        return interactWithUserService.askUser();
    }

    @Override
    public void sayWelcomeToUser(String userName) {
        interactWithUserService.sayToUser("user.greeting", userName);
    }

    @Override
    public void sayTestPassed() {
        interactWithUserService.sayToUser("user.test.passed");
    }

    @Override
    public void sayTestFailed() {
        interactWithUserService.sayToUser("user.test.failed");
    }
}
