package com.djungleacademy.exceptions;

public class CourseNotFoundEx extends RuntimeException {
    public CourseNotFoundEx(String message) {
        super(message);
    }
}
