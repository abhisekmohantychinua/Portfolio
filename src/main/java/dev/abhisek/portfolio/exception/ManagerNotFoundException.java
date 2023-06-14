package dev.abhisek.portfolio.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.function.Supplier;

public class ManagerNotFoundException extends UsernameNotFoundException implements Supplier<ManagerNotFoundException> {
    public ManagerNotFoundException() {
        super("Requested Manager not found on server.");
    }

    @Override
    public ManagerNotFoundException get() {
        return new ManagerNotFoundException();
    }
}
