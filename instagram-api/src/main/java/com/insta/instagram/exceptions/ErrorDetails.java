package com.insta.instagram.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorDetails(String message, String description, LocalDate now) {

    }
}
