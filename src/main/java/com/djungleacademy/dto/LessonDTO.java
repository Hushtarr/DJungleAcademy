package com.djungleacademy.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {
    private Long id;

    @NotBlank(message="Name must not be blank")
    private String name;

    @NotBlank(message="Must have an instructor")
    private String instructor;

    @NotBlank(message="Credit must not be blank")
    private Integer credit;

    private String course;
}
