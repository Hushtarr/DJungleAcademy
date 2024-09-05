package com.djungleacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageType {
    READ("Read"),UNREAD("Unread");
    private final String value;

}
