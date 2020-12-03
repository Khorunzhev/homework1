package ru.otus.spring.homework1;

import org.springframework.context.annotation.*;
import ru.otus.spring.homework1.serivce.survey.SurveyCheckService;
import ru.otus.spring.homework1.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework1.serivce.utils.InteractWithUserServiceImpl;

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