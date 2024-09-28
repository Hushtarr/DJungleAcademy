package com.djungleacademy.service.impl;

import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.CourseLesson;
import com.djungleacademy.entity.Lesson;
import com.djungleacademy.repository.CourseLessonRepository;
import com.djungleacademy.repository.CourseRepository;
import com.djungleacademy.repository.LessonRepository;
import com.djungleacademy.service.CourseLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseLessonServiceImpl implements CourseLessonService {
    private final CourseLessonRepository courseLessonRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;


    @Override
    public List<CourseLesson> findByLessonId(Long lessonId) {
        return courseLessonRepository.findByLessonId(lessonId);
    }

    @Override
    public List<CourseLesson> findByCourseId(Long courseId) {
        return courseLessonRepository.findByCourseId(courseId);
    }

    @Override
    public List<CourseLesson> findAll() {
        return courseLessonRepository.findAll();
    }

    @Override
    public void save() {
        CourseLesson courseLesson = new CourseLesson();
       List<Course>courses = courseRepository.findAll();
       for (Course course : courses) {
           courseLesson.setCourse(course);
           courseLessonRepository.save(courseLesson);
       }
       List<Lesson>lessons = lessonRepository.findAll();
       for (Lesson lesson : lessons) {
           courseLesson.setLesson(lesson);
           courseLessonRepository.save(courseLesson);
       }
       courseLessonRepository.save(courseLesson);
    }
}
