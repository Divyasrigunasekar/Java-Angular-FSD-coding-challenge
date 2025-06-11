package com.hexaware.cricketteam.exceptions;

public class InvalidPlayerDataException extends RuntimeException {
    public InvalidPlayerDataException(String message) {
        super(message);
    }
}