package com.djungleacademy;

import com.djungleacademy.mapper.LessonMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@EnableGlobalAuthentication
@SpringBootApplication
public class DJungleAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DJungleAcademyApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
