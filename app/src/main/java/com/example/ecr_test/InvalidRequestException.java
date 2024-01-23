package com.example.ecr_test;

import java.text.ParseException;

public class InvalidRequestException extends Exception {

    public InvalidRequestException(String message) {
        super(message);
    }
}
