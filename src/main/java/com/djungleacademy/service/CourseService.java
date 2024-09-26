package com.djungleacademy.service;

import com.djungleacademy.dto.CourseDTO;

import java.util.List;

public interface CourseService {


    void save(CourseDTO courseDTO);

    CourseDTO getCourseById(Long id);

    List<CourseDTO> findAll();

    void updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);
}
