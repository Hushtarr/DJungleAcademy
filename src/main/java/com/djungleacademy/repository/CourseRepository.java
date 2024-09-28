package com.djungleacademy.repository;

import com.djungleacademy.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByIsDeleted(Boolean isDeleted);
}
