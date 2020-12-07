package ru.otus.spring.homework.serivce.questions.formatter;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.configuration.SurveyConfig;
import ru.otus.spring.homework.model.FreeFormQuestion;
import ru.otus.spring.homework.model.MultipleChoiceQuestion;
import ru.otus.spring.homework.model.Question;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionFormatterService {

    private final MessageSource messageSource;
    private final SurveyConfig surveyConfig;

    public String formatQuestionAnswer(Question question) {
        if (question instanceof MultipleChoiceQuestion) {
            return String.format(getMultipleAnswersQuestionFormativeString(),
                    question.getQuestionText(),
                    formatMultipleAnswers(((MultipleChoiceQuestion) question).getAnswers()));
        } else if (question instanceof FreeFormQuestion) {
            return String.format(getFreeFormQuestionFormativeString(),
                    question.getQuestionText());
        } else {
            return "Передан неверный тип вопроса";
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
        return messageSource.getMessage("survey.question", null, surveyConfig.getLocale());
    }

    private String getPossibleAnswersString() {
        return messageSource.getMessage("survey.question.answers", null, surveyConfig.getLocale());
    }

    private String getResponseString() {
        return messageSource.getMessage("survey.question.response", null, surveyConfig.getLocale());
    }
}
