package com.djungleacademy.service;

import com.djungleacademy.entity.CourseLesson;

import java.util.ArrayList;
import java.util.List;

public interface CourseLessonService {
    List<CourseLesson> findByLessonId(Long lessonId);
    List<CourseLesson> findByCourseId(Long courseId);
    List<CourseLesson> findAll();
    void save();
}
