package com.emailService.util;

import com.emailService.model.EmailModel;
import com.resend.services.emails.model.CreateEmailOptions;

public class EmailBuilder {
    public static CreateEmailOptions Build(EmailModel email) {

        return CreateEmailOptions.builder()
                .from("Acme " + email.getFrom())
                .to(email.getTo())
                .subject(email.getTitle())
                .html(email.getBody())
                .build();
    }

}
