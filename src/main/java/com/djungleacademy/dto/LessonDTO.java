package com.djungleacademy.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"instructor", "course"}) // ignore instructor and course field
public class LessonDTO {
    private Long id;

    @NotBlank(message="Name must not be blank")
    private String name;

    @NotBlank(message="Must have an instructor")
    private String instructorName;

    @NotBlank(message="Credit must not be blank")
    private Integer credit;

    @NotBlank(message="Course must not be blank")
    private String courseName;

    private UserDTO instructor;
    private CourseDTO course;
}
