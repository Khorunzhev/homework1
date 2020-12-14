package ru.otus.spring.homework.serivce.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

@ShellComponent
@RequiredArgsConstructor
public class ShellEventsCommands {

    private final SurveyCheckService surveyCheckService;
    private final InteractWithUserService interactWithUserService;
    private final LocalizationService localizationService;

    private boolean isTestAlreadyLaunched;

    @ShellMethod(value = "Run survey", key = {"r", "RunSurvey"})
    public void runSurvey() {
        interactWithUserService.sayToUser("survey.launched");
        surveyCheckService.getSurveyResult();
        isTestAlreadyLaunched = true;
    }


    @ShellMethod(value = "Get number of right answers", key = {"Answers", "a"})
    @ShellMethodAvailability(value = "isTestAlreadyPassed")
    public int getNumberOfRightAnswers() {
        return surveyCheckService.getNumberOfRightAnswers();
    }

    private Availability isTestAlreadyPassed() {
        return isTestAlreadyLaunched ?
                Availability.available()
                : Availability.unavailable(
                localizationService.getLocalizationString("survey.launchfirst"));
    }


}
