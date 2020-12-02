package ru.otus.spring.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.homework1.serivce.survey.SurveyCheckService;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        SurveyCheckService service = context.getBean(SurveyCheckService.class);

        service.runSurvey();
    }
}