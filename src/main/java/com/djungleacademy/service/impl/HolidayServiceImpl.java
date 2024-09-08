package com.djungleacademy.service.impl;

import com.djungleacademy.dto.HolidaysDTO;
import com.djungleacademy.enums.HolidayType;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.HolidayRepository;
import com.djungleacademy.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository holidayRepository;
    private final GlobalMapper mapper;

    @Override
    public List<HolidaysDTO> getFederatedHolidays() {
        return getHolidaysByType(HolidayType.FEDERAL);
    }

    @Override
    public List<HolidaysDTO> getFestivalHolidays() {
        return getHolidaysByType(HolidayType.FESTIVAL);
    }

    private List<HolidaysDTO> getHolidaysByType(HolidayType type) {
        return holidayRepository.findAll().stream()
                .filter(entity -> entity.getHolidayType().equals(type))
                .map(entity -> mapper.convert(entity, HolidaysDTO.class))
                .toList();
    }

}
