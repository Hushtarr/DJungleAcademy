package com.djungleacademy.service.impl;

import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.User;
import com.djungleacademy.exceptions.CourseNotFoundEx;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.CourseRepository;
import com.djungleacademy.service.CourseService;
import com.djungleacademy.service.LessonService;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final GlobalMapper mapper;

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepository.save(mapper.convert(courseDTO, Course.class));
    }

    @Override
    public CourseDTO findById(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(()->new CourseNotFoundEx("no such course.html"));
        return mapper.convert(course, CourseDTO.class);
    }

    @Override
    public CourseDTO findByName(String courseName) {
        Course course=courseRepository.findByIsDeletedAndName(false,courseName);
        return mapper.convert(course, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream()
                .filter(course -> !course.getIsDeleted())
                .map(course -> {
                    CourseDTO dto = mapper.convert(course, CourseDTO.class);
                    long activeCount = course.getLessons()
                            .stream()
                            .filter(lesson -> !lesson.getIsDeleted())
                            .count();
                    dto.setActiveLessonsCount(activeCount);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long id, CourseDTO courseDTO) {

    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundEx("Course not found with id: " + id));
        course.setIsDeleted(true);
        courseRepository.save(course);
        }


}

