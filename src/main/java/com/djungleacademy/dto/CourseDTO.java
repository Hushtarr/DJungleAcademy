package com.djungleacademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;

    @NotBlank(message="Name must not be blank")
    private String name;

    @NotNull(message="Must have a professor")
    private UserDTO professor;

    private List<LessonDTO> lessons;
}
