package com.djungleacademy.repository;

import com.djungleacademy.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
    
}
