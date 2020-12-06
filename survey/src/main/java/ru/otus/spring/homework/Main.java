package ru.otus.spring.homework;

import org.springframework.context.annotation.*;
import ru.otus.spring.homework.serivce.survey.SurveyCheckService;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        SurveyCheckService service = context.getBean(SurveyCheckService.class);

        service.getSurveyResult();
    }
}