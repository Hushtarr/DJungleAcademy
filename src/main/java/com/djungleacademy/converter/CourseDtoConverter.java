package com.djungleacademy.converter;

import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.exceptions.CourseNotFoundEx;
import com.djungleacademy.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseDtoConverter implements Converter<String, CourseDTO> {
    private final CourseService courseService;

    @Override
    public CourseDTO convert(String source) {
        if (source.trim().isEmpty()) {
            throw new CourseNotFoundEx("Course with id " + source + " not found");
        }
        Long courseId = Long.valueOf(source);
        CourseDTO courseDTO = courseService.getCourseById(courseId);
        if (courseDTO == null) {
            throw new CourseNotFoundEx("Course with id " + courseId + " not found");
        }
        return courseDTO;
    }
}
