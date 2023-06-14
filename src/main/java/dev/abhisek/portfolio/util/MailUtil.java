package dev.abhisek.portfolio.util;

import dev.abhisek.portfolio.model.Mail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    private static JavaMailSender javaMailSender = null;


    private static String DEV_MAIL;

    @Autowired
    public MailUtil(JavaMailSender javaMailSender) {
        MailUtil.javaMailSender = javaMailSender;
    }

    @Value("${static.data.dev-mail}")
    public void setDevMail(String devMail) {
        DEV_MAIL = devMail;
    }

    public static void sendMail(Mail mail) throws MessagingException {
        System.out.println(DEV_MAIL);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(DEV_MAIL);
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getMessages());

        javaMailSender.send(mimeMessage);

    }
}
