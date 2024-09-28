package com.djungleacademy.repository;

import com.djungleacademy.entity.CourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long> {
    List<CourseLesson> findByCourseId(Long courseId);
    List<CourseLesson> findByLessonId(Long lessonId);
    List<CourseLesson> findAllByIsDeletedFalse();
}
