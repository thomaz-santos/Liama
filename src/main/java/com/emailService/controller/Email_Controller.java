package com.emailService.controller;

import com.emailService.model.EmailLiame;
import com.emailService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Liame")
public class Email_Controller {

    @GetMapping(path = "/list")
    @ResponseStatus(HttpStatus.OK)
    public String list() {
        return EmailService.listAll();
    }

    @GetMapping(path = "/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String list(@PathVariable String id) {
        return EmailService.listAll(id);
    }

    @PostMapping(path = "/send")
    @ResponseStatus(HttpStatus.CREATED)
    public String send(@RequestBody EmailLiame email) {
        EmailService.send(email);
        return email.toString();
    }

    @PostMapping(path = "/default/{to}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmailLiame defaultResponse(@PathVariable String to) {
        return EmailService.defaultResponse(to);
    }
}
