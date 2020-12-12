package ru.otus.spring.homework.serivce.utils.localisation;

public interface LocalizationService {

    String getLocalizationString(String localisationPropertyName);
    String getLocalizationString(String localisationPropertyName, Object[] s);

}
