package com.djungleacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseLessonDTO {
    private Long id;
    private CourseDTO course;
    private LessonDTO lesson;
}
