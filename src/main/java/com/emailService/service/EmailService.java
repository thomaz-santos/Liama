package com.emailService.service;

import com.emailService.domain.EmailLiame;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    private static List<EmailLiame> emails;

    static {
        emails = new ArrayList<EmailLiame>(List.of(new EmailLiame("Liame1", "Teste 1", "Acme <onboarding@resend.dev>", "thomazvieira.santos09@gmail.com"),
                                                   new EmailLiame("Liame2", "Teste 2", "Acme <onboarding@resend.dev>", "thomazvieira.santos09@gmail.com")));
    }

    public static List<EmailLiame> listAll() {
        return emails;
    }

    public static EmailLiame send(EmailLiame email) {
        Resend resend = new Resend("re_cFgnZdiX_Ft5eYaoTkiTku3hVgv5PLm5C");

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("Acme " + email.getFrom())
                .to(email.getTo())
                .subject(email.getTitle())
                .html(email.getBody())
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }

        emails.add(email);
        return email;
    }
}
