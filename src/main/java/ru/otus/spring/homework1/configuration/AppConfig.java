package ru.otus.spring.homework1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.homework1.serivce.utils.InteractWithUserService;
import ru.otus.spring.homework1.serivce.utils.InteractWithUserServiceImpl;

@Configuration
@ComponentScan("ru.otus.spring.homework1")
public class AppConfig {

    @Bean
    InteractWithUserService interactWithUserService() {
        return new InteractWithUserServiceImpl(System.out, System.in);
    }

}
