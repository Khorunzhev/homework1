package ru.otus.spring.homework.serivce.questions.formatter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.model.FreeFormQuestion;
import ru.otus.spring.homework.model.MultipleChoiceQuestion;
import ru.otus.spring.homework.model.Question;
import ru.otus.spring.homework.serivce.utils.localisation.LocalizationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionFormatterService {

    private final LocalizationService localizationService;

    public String formatQuestionAnswer(Question question) {
        if (question instanceof MultipleChoiceQuestion) {
            return String.format(getMultipleAnswersQuestionFormativeString(),
                    question.getQuestionText(),
                    formatMultipleAnswers(((MultipleChoiceQuestion) question).getAnswers()));
        } else if (question instanceof FreeFormQuestion) {
            return String.format(getFreeFormQuestionFormativeString(),
                    question.getQuestionText());
        } else {
            return localizationService.getLocalizationString("survey.file.question.error");
        }
    }

    private String formatMultipleAnswers(List<String> answers) {
        return answers.stream()
                .map(string -> String.format("= %s =", string))
                .collect(Collectors.joining());
    }

    private String getMultipleAnswersQuestionFormativeString() {
        return
                getQuestionString() + ": %s \n" +
                getPossibleAnswersString() + ": %s \n" +
                getResponseString() + ": ";
    }

    private String getFreeFormQuestionFormativeString() {
        return
                getQuestionString() + ": %s \n" +
                getResponseString() + ": ";
    }

    private String getQuestionString() {
        return localizationService.getLocalizationString("survey.question");
    }

    private String getPossibleAnswersString() {
        return localizationService.getLocalizationString("survey.question.answers");
    }

    private String getResponseString() {
        return localizationService.getLocalizationString("survey.question.response");
    }
}
