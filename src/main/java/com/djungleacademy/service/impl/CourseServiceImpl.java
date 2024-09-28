package com.djungleacademy.service.impl;

import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.User;
import com.djungleacademy.exceptions.CourseNotFoundEx;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.CourseRepository;
import com.djungleacademy.service.CourseService;
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
    private final UserService userService;

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepository.save(mapper.convert(courseDTO, Course.class));
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(()->new CourseNotFoundEx("no such course.html"));
        return mapper.convert(course, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream()
                .filter(obj-> obj.getIsDeleted().equals(false))
                .map(obj->mapper.convert(obj,CourseDTO.class))
                .toList();
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

    @Override
    public List<CourseDTO> findRemainingCourses() {
        return courseRepository.findAllByIsDeleted(false).stream()
                .map(course->mapper.convert(course, CourseDTO.class))
                .collect(Collectors.toList());
    }
}

