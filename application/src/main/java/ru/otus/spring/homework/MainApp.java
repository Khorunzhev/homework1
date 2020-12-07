package ru.otus.spring.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainApp.class);
        SurveyCheckService service = context.getBean(SurveyCheckService.class);

        service.getSurveyResult();
    }
}
