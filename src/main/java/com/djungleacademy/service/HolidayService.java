package com.djungleacademy.service;

import com.djungleacademy.dto.HolidaysDTO;

import java.util.List;

public interface HolidayService {
    List<HolidaysDTO>getFederatedHolidays();
    List<HolidaysDTO>getFestivalHolidays();
}
