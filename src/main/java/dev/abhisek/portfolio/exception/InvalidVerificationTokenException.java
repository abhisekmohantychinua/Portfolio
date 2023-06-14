package dev.abhisek.portfolio.exception;

import java.util.function.Supplier;

public class InvalidVerificationTokenException extends RuntimeException implements Supplier<InvalidVerificationTokenException> {

    public InvalidVerificationTokenException() {
        super("The Request token provided is malformed, already verified or doesn't exist.");
    }

    @Override
    public InvalidVerificationTokenException get() {
        return new InvalidVerificationTokenException();
    }
}
