package com.example.mod1.spring_homework.homework4;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.mod1.spring_homework.homework4")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
    @Bean
    @Scope("singleton")
    //@Scope("prototype")
    public Pet dogBean(){
        System.out.println("Some message for test dog");
        return new Dog();
    }

    @Bean
    public Person personBean(){
        System.out.println("Some message for test person");
        return new Person(dogBean());
    }
}
