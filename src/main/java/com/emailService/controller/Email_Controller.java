package com.emailService.controller;

import com.emailService.domain.EmailLiame;
import com.emailService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Liame")
public class Email_Controller {

    @GetMapping(path = "list")
    public List<EmailLiame> list() {
        return EmailService.listAll();
    }

    @PostMapping(path = "/send/{title}&{body}")
    public void send(@PathVariable String title, @PathVariable String body) {
        EmailLiame email = new EmailLiame(title, body, "<onboarding@resend.dev>", "thomazvieira.santos09@gmail.com");
        EmailService.send(email);

    }

}
