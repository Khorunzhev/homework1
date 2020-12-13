package ru.otus.spring.homework.serivce.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

@ShellComponent
@AllArgsConstructor
public class ShellEventsCommands {

    SurveyCheckService surveyCheckService;
    InteractWithUserService interactWithUserService;

    @ShellMethod(value = "Run survey", key = {"r", "RunSurvey"})
    public void runSurvey() {
        interactWithUserService.sayToUser("survey.launched");
        surveyCheckService.getSurveyResult();
    }

}
