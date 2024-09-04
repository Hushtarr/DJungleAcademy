package com.djungleacademy.controller;

import com.djungleacademy.enums.HolidayType;
import com.djungleacademy.dto.HolidaysDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class HolidayController {
    // -----> RequestParam
    /*@GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean a_holidays,
                                  @RequestParam(required = false) boolean b_holidays,
                                  Model model){//required = false it's mean the param is not required
        // requestParam variable name should be the same one in HTML where it's come from → where define the url
        //model attribute name should be the same one in HTML where it will be used → where define the element
        model.addAttribute("festivals",a_holidays);
        model.addAttribute("federals",b_holidays);*/


    // -----> PathVariable
    @GetMapping("/holidays/{display}")
    public String holidays(@PathVariable String display, Model model)
    {
        if(null != display && display.equals("all")){
            model.addAttribute("festivals",true);
            model.addAttribute("federals",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federals",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festivals",true);
        }
        List<HolidaysDTO> holidays = Arrays.asList(
                new HolidaysDTO(" Jan 1 ","New Year's Day", HolidayType.FESTIVAL),
                new HolidaysDTO(" Oct 31 ","Halloween", HolidayType.FESTIVAL),
                new HolidaysDTO(" Nov 24 ","Thanksgiving Day", HolidayType.FESTIVAL),
                new HolidaysDTO(" Dec 25 ","Christmas", HolidayType.FESTIVAL),
                new HolidaysDTO(" Jan 17 ","Martin Luther King Jr. Day", HolidayType.FEDERAL),
                new HolidaysDTO(" July 4 ","Independence Day", HolidayType.FEDERAL),
                new HolidaysDTO(" Sep 5 ","Labor Day", HolidayType.FEDERAL),
                new HolidaysDTO(" Nov 11 ","Veterans Day", HolidayType.FEDERAL)
        );
        HolidayType[] types = HolidayType.values();
        for (HolidayType type : types) {
            model.addAttribute(type.toString(),
                    (holidays
                            .stream()
                            .filter(holiday -> holiday.getHolidayType().equals(type))
                            .collect(Collectors.toList())));
        }
        return "holidays";
    }
}
