package ru.otus.spring.homework.serivce.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCommunicationServiceImpl implements UserCommuncationService {

    InteractWithUserService interactWithUserService;

    @Override
    public void sayHelloToUser() {
        interactWithUserService.writeTo("Hello user");
    }

    @Override
    public void sayTestPassed() {
        interactWithUserService.writeTo("Test passed");
    }

    @Override
    public void sayTestFailed() {
        interactWithUserService.writeTo("Test failed");
    }
}
