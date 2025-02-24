package com.emailService.util;

import com.emailService.model.EmailLiame;
import com.resend.services.emails.model.CreateEmailOptions;

public class EmailBuilder {
    public static CreateEmailOptions Build(EmailLiame email) {

        return CreateEmailOptions.builder()
                .from("Acme " + email.getFrom())
                .to(email.getTo())
                .subject(email.getTitle())
                .html(email.getBody())
                .build();
    }

}
