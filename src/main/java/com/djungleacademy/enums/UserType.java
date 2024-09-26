package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UserType {
        ADMIN("Admin"),PROFESSOR("Professor"),INSTRUCTOR("Instructor"),STUDENT("Student");
        private final String value;

}
