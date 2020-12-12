package ru.otus.spring.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(MainApp.class, args);
        SurveyCheckService service = app.getBean(SurveyCheckService.class);
        service.getSurveyResult();
    }
}
