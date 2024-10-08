package com.djungleacademy.repository;

import com.djungleacademy.entity.Course;
import com.djungleacademy.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByIsDeletedFalse();
}
