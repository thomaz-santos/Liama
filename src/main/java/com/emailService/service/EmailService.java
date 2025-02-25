package com.emailService.service;

import com.resend.*;
import com.emailService.model.EmailLiame;
import com.emailService.util.EmailBuilder;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmailService {
    public static Dotenv dotenv;

    public EmailService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    private static List<EmailLiame> emails;

    static {
        emails = new ArrayList<>(List.of(new EmailLiame("Liame1", "Teste 1", "Acme <onboarding@resend.dev>", "thomazvieira.santos09@gmail.com", UUID.randomUUID().toString()),
                                                   new EmailLiame("Liame2", "Teste 2", "Acme <onboarding@resend.dev>", "thomazvieira.santos09@gmail.com", UUID.randomUUID().toString())));
    }

    public static String listAll() {
        return emails.toString();
    }

    public static String listAll(String id) {
        for(EmailLiame email: emails) {
            if (email.getId().equals(id)) {
                return email.toString();
            };
        }
        return "null response";
    }

    public static EmailLiame defaultResponse(String to) {
        Resend resend = new Resend(dotenv.get("RESEND_KEY"));

        EmailLiame email = new EmailLiame("Default Email", "This is a default endpoint for test purpose", "<onboarding@resend.dev>", to);

        CreateEmailOptions params = EmailBuilder.Build(email);

        try {
            CreateEmailResponse data = resend.emails().send(params);
            email.setId(data.getId());
            System.out.println(data.getId());
        } catch (ResendException e) {
            System.out.println(email.getTo());
            e.printStackTrace();
        }

        return email;
    }


    public static EmailLiame send(EmailLiame email) {
        Resend resend = new Resend(dotenv.get("RESEND_KEY"));

        CreateEmailOptions params = EmailBuilder.Build(email);

        try {
            CreateEmailResponse data = resend.emails().send(params);
            email.setId(data.getId());
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }

        emails.add(email);
        return email;
    }


}
