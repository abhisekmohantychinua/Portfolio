package dev.abhisek.portfolio.service;

import dev.abhisek.portfolio.model.Contact;
import jakarta.mail.MessagingException;

import java.security.NoSuchAlgorithmException;

public interface ContactService {
    void addContact(Contact contact) throws NoSuchAlgorithmException, MessagingException;
    Contact verifyContact(String token);
}
