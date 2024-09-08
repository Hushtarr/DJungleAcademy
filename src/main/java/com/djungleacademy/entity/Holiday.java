package com.djungleacademy.entity;

import com.djungleacademy.enums.HolidayType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Data
    @Entity
    @NoArgsConstructor
    @Table(name = "holidays")
    public class Holiday {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        private Long id;

        @Column(nullable = false)
        private String day;

        @Column(nullable = false)
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false,name = "holiday_type")
        private HolidayType holidayType;

    }


