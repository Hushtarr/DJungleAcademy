package com.djungleacademy.dto;

import com.djungleacademy.enums.HolidayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidaysDTO {
    private String day;
    private String description;
    private HolidayType holidayType;


}
