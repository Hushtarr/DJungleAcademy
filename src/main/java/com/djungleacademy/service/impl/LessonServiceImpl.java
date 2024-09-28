package com.djungleacademy.service.impl;

import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.Lesson;
import com.djungleacademy.exceptions.LessonNotFoundEx;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.LessonRepository;
import com.djungleacademy.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final GlobalMapper mapper;
    @Override
    public LessonDTO findById(Long id) {
        Lesson lesson=lessonRepository.findById(id).orElseThrow(()->new LessonNotFoundEx("Lesson not found"));
        return mapper.convert(lesson, LessonDTO.class);
    }

    @Override
    public void save(LessonDTO lessonDTO) {
        lessonRepository.save(mapper.convert(lessonDTO, Lesson.class));
    }

    @Override
    public List<LessonDTO> findAll() {
        return lessonRepository.findAll().stream()
                .filter(lesson-> !lesson.getIsDeleted())
                .map(lesson->mapper.convert(lesson,LessonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundEx("Lesson not found with id: " + id));

        lesson.setIsDeleted(true);
        Course  course=lesson.getCourse();
        course.getLessons().remove(lesson);
        lessonRepository.save(lesson);
    }

    @Override
    public List<LessonDTO> findRemainingLessons() {
        return lessonRepository.findAllByIsDeleted(false).stream()
                .map(lesson->mapper.convert(lesson,LessonDTO.class))
                .collect(Collectors.toList());
    }
}
