package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UserType {
        ADMIN("Admin"),PROFESSOR("Professor"),STUDENT("Student");
        private final String value;

}
