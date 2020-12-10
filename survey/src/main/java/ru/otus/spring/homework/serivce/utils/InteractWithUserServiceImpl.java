package ru.otus.spring.homework.serivce.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

@AllArgsConstructor
@Service
public class InteractWithUserServiceImpl implements InteractWithUserService {

    private final InputOutputWrapper inputOutputWrapper;
    private final LocalizationService localizationService;

    @Override
    public String askUser() {
        return inputOutputWrapper.readFrom();
    }

    @Override
    public void sayToUser(String message, String... values) {
        inputOutputWrapper.writeTo(localizationService.getLocalizationString(message, values));
    }
}
