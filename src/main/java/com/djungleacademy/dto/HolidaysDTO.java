package com.djungleacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidaysDTO {
    private String day;
    private String description;
    private HolidayType holidayType;


}
