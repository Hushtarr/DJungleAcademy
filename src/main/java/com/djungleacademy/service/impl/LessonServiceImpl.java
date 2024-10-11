package com.djungleacademy.service.impl;

import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.Lesson;
import com.djungleacademy.exceptions.LessonNotFoundEx;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.mapper.LessonMapper;
import com.djungleacademy.repository.CourseRepository;
import com.djungleacademy.repository.LessonRepository;
import com.djungleacademy.repository.UserRepository;
import com.djungleacademy.service.CourseService;
import com.djungleacademy.service.LessonService;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseService courseService;
    private final GlobalMapper mapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final LessonMapper lessonMapper;


    @Override
    public LessonDTO findById(Long id) {
        Lesson lesson=lessonRepository.findById(id).orElseThrow(()->new LessonNotFoundEx("Lesson not found"));
        return mapper.convert(lesson, LessonDTO.class);
    }

    @Override
    public void save(LessonDTO lessonDTO) {
        Lesson lesson=lessonMapper.toEntity(lessonDTO);
        lessonRepository.save(lesson);
    }

    @Override
    public List<LessonDTO> findAll() {
        return lessonRepository.findAllByIsDeletedFalse().stream()
                .map(lessonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundEx("Lesson not found with id: " + id));

        lesson.setIsDeleted(true);
        lessonRepository.save(lesson);

        Course  course=lesson.getCourse();
        course.getLessons().removeIf(l -> l.getId().equals(lesson.getId()));
        courseRepository.save(course);
    }


}
