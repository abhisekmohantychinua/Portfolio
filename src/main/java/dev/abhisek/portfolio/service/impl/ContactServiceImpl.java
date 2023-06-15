package dev.abhisek.portfolio.service.impl;

import dev.abhisek.portfolio.exception.InvalidVerificationTokenException;
import dev.abhisek.portfolio.model.Contact;
import dev.abhisek.portfolio.model.Mail;
import dev.abhisek.portfolio.repository.ContactRepository;
import dev.abhisek.portfolio.service.ContactService;
import dev.abhisek.portfolio.util.MailUtil;
import dev.abhisek.portfolio.util.ModelUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;

    @Override
    public void addContact(Contact contact) throws NoSuchAlgorithmException, MessagingException {
        contact.setId(UUID.randomUUID().toString());
        contact.setVerified(false);

        contact.setToken(ModelUtil.getEncryptedToken(contact));
        repository.save(contact);
        MailUtil.sendMail(Mail.builder()
                .to(contact.getEmail())
                .subject("Email verification !!!")
                .messages("Thanks for contacting me. Please verify your email by clicking on the following link:" +
                        "https://coderabhisek.onrender.com" +
                        "/verify?token=" +
                        contact.getToken())
                .build());
    }

    @Override
    public Contact verifyContact(String token) {
        Contact contact = repository
                .findByTokenAndVerifiedFalse(token)
                .orElseThrow(InvalidVerificationTokenException::new);
        contact.setVerified(true);
        repository.save(contact);
        return contact;
    }
}
