package com.djungleacademy.controller;

import com.djungleacademy.dto.HolidayType;
import com.djungleacademy.dto.HolidaysDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays")
    public String displayHolidays(Model model) {
        List<HolidaysDTO> holidays = Arrays.asList(
                new HolidaysDTO(MonthDay.of(1, 1), "New Year's Day", HolidayType.FESTIVAL),
                new HolidaysDTO(MonthDay.of(10, 31), "Halloween", HolidayType.FESTIVAL),
                new HolidaysDTO(MonthDay.of(11, 24), "Thanksgiving Day", HolidayType.FESTIVAL),
                new HolidaysDTO(MonthDay.of(12, 25), "Christmas", HolidayType.FESTIVAL),
                new HolidaysDTO(MonthDay.of(1, 17), "Martin Luther King Jr. Day", HolidayType.FEDERAL),
                new HolidaysDTO(MonthDay.of(7, 4), "Independence Day", HolidayType.FEDERAL),
                new HolidaysDTO(MonthDay.of(9, 5), "Labor Day", HolidayType.FEDERAL),
                new HolidaysDTO(MonthDay.of(11, 11), "Veterans Day", HolidayType.FEDERAL)
        );
        HolidayType[] types = HolidayType.values();
        for (HolidayType type : types) {
            model.addAttribute(type.toString(),
                    (holidays
                            .stream()
                            .filter(holiday -> holiday.getHolidayType().equals(type))
                            .collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
