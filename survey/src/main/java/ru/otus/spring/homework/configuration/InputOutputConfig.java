package ru.otus.spring.homework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.homework.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework.serivce.utils.InteractWithUserServiceImpl;

@Configuration
@ComponentScan("ru.otus.spring.homework")
public class InputOutputConfig {

    @Bean
    InteractWithUserService interactWithUserService() {
        return new InteractWithUserServiceImpl(System.out, System.in);
    }

}
