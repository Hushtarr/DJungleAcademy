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
    private MonthDay day;
    private String description;
    private HolidayType holidayType;

    public String getFormattedDay() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        return this.day.format(formatter);
    }

}
