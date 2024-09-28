package com.djungleacademy.entity;

import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.dto.LessonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CourseLesson extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER) // 表示与 Course 的多对一关系
    @JoinColumn(name = "course_id", nullable = false) // 指定外键列，并且不能为空
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER) // 表示与 Lesson 的多对一关系
    @JoinColumn(name = "lesson_id", nullable = false) // 指定外键列，并且不能为空
    private Lesson lesson;
}
