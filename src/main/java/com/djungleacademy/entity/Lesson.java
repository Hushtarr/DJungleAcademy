package com.djungleacademy.entity;

import com.djungleacademy.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends BaseEntity{

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User instructor;

    private Integer credit;
}
