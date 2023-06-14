package dev.abhisek.portfolio.exception.handler;

import dev.abhisek.portfolio.exception.NOExplicitMapping;
import dev.abhisek.portfolio.model.Mail;
import dev.abhisek.portfolio.util.MailUtil;
import jakarta.mail.MessagingException;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final String ERROR_PAGE = "errorpage";

    @Value("${static.data.admin-mail}")
    private String ADMIN_MAIL;

    @Builder
    @Data
    public static class ErrorModel {
        private String heading;
        private String message;
    }

    @ExceptionHandler(NOExplicitMapping.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundError(NOExplicitMapping exception, Model model) {
        model.addAttribute("errorModel",
                ErrorModel
                        .builder()
                        .heading("404")
                        .message("No Explicit mapping for this page.")
                        .build());

        return ERROR_PAGE;
    }

    public String handleIllegalArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("errorModel",
                ErrorModel
                        .builder()
                        .heading("500")
                        .message("Some error occurred during sending mail")
                        .build());
        return ERROR_PAGE;
    }

    @ExceptionHandler(MessagingException.class)
    public String handleMessagingException(MessagingException e, Model model) {
        // TODO: 13-06-2023 If Some failure occurs in sending the mail the error stack trace should be stored in local storage
        model.addAttribute("errorModel",
                ErrorModel
                        .builder()
                        .heading("500")
                        .message("Some error occurred during sending mail")
                        .build());
        return ERROR_PAGE;
    }


    @ExceptionHandler(Exception.class)
    public String handle(Exception e, Model model) throws MessagingException {
        MailUtil.sendMail(Mail
                .builder()
                .to(ADMIN_MAIL)
                .subject("Unhandled server error logs")
                .messages(Arrays.toString(e.getStackTrace()))
                .build());

        model.addAttribute("errorModel",
                ErrorModel
                        .builder()
                        .heading("500")
                        .message("Some Internal server error occurred")
                        .build());
        return ERROR_PAGE;
    }
}
