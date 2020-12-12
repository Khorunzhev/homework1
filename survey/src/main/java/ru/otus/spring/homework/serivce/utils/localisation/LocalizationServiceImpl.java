package ru.otus.spring.homework.serivce.utils.localisation;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;

@AllArgsConstructor
@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final SurveyConfig surveyConfig;
    private final MessageSource messageSource;

    @Override
    public String getLocalizationString(final String localizationPropertyName) {
        return messageSource.getMessage(localizationPropertyName, null, surveyConfig.getLocale());
    }

    @Override
    public String getLocalizationString(final String localizationPropertyName, Object[] parameters) {
        return messageSource.getMessage(localizationPropertyName, parameters, surveyConfig.getLocale());
    }

}
