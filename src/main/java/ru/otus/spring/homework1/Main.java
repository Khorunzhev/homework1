package ru.otus.spring.homework1;

import lombok.extern.java.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.homework1.serivce.QuestionPrintService;

@Log
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionPrintService service = context.getBean(QuestionPrintService.class);
        service.printAllQuestions();
    }
}