package com.djungleacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private User professor;

    @OneToMany(mappedBy = "course")// this course comes from lesson class; it's mean this filed managed by course filed in lesson class
    private List<Lesson>lessons;
}
