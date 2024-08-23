package com.djungleacademy.config;

import com.djungleacademy.dto.HolidayType;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry view){
        // static pages
        view.addViewController("/courses").setViewName("courses");
        view.addViewController("/about").setViewName("about");
    }
}
