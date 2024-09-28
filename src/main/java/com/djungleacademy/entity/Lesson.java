package com.djungleacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson extends BaseEntity{

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private User instructor;

    private Integer credit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
}
