package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;



    @Getter
    @AllArgsConstructor
    public enum HolidayType {
        FEDERAL("Federal"),FESTIVAL("Festival");
        private final String value;

    }

