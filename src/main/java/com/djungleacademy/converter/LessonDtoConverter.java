package com.djungleacademy.converter;

import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.exceptions.LessonNotFoundEx;
import com.djungleacademy.exceptions.UserNotFoundEx;
import com.djungleacademy.service.LessonService;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonDtoConverter implements Converter<String, LessonDTO> {
    private final LessonService lessonService;


    @Override
    public LessonDTO convert(String source) {
        if (source.trim().isEmpty()) {
            throw new LessonNotFoundEx("User with ID " + source + " not found");
        }
        Long lessonId = Long.parseLong(source);
        LessonDTO lessonDTO = lessonService.findById(lessonId);

        if (lessonDTO == null) {
            throw new LessonNotFoundEx("User with ID " + source + " not found");
        }

        return lessonDTO;



    }

}
