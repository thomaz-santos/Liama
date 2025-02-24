package com.emailService.controller;

import com.emailService.model.EmailLiame;
import com.emailService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Liame")
public class Email_Controller {

    @GetMapping(path = "/list")
    public String list() {
        return EmailService.listAll();
    }

    @GetMapping(path = "/default")
    public EmailLiame defaultResponse(@RequestBody String to) {
        return EmailService.defaultResponse(to);
    }

    @PostMapping(path = "/send")
    @ResponseStatus(HttpStatus.CREATED)
    public String send(@RequestBody EmailLiame email) {
        EmailService.send(email);
        return email.toString();
    }

}
