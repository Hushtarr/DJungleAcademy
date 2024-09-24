package com.djungleacademy.exceptions;

public class LessonNotFoundEx extends RuntimeException {
    public LessonNotFoundEx(String message) {
        super(message);
    }
}
