package com.djungleacademy.service;

import com.djungleacademy.dto.LessonDTO;

import java.util.List;

public interface LessonService {
    LessonDTO findById(Long id);
    void save(LessonDTO lessonDTO);
    List<LessonDTO> findAll();
    void delete(Long id);
    List<LessonDTO> findRemainingLessons();
}
