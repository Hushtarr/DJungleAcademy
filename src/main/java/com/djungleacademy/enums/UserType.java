package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UserType {
        ADMIN("Admin"),INSTRUCTOR("Instructor"),STUDENT("Student");
        private final String value;

}
