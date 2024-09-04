package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactType {
    USER("User"),ANONYMOUS("Anonymous");
    private final String value;

}
