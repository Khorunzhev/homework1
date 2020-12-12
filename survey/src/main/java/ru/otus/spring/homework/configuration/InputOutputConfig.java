package ru.otus.spring.homework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.homework.serivce.utils.InputOutputWrapper;
import ru.otus.spring.homework.serivce.utils.InputOutputWrapperImpl;

@Configuration
@ComponentScan("ru.otus.spring.homework")
public class InputOutputConfig {

    @Bean
    InputOutputWrapper interactWithUserService() {
        return new InputOutputWrapperImpl(System.out, System.in);
    }

}
