package com.emailService.controller;

import com.emailService.model.EmailModel;
import com.emailService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Liame/email")
public class Email_Controller {

    @GetMapping(path = "/listTasks")
    @ResponseStatus(HttpStatus.OK)
    public String list() {
        return EmailService.listAll();
    }

    @GetMapping(path = "/listTasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String list(@PathVariable String id) {
        return EmailService.listAll(id);
    }

    @PostMapping(path = "/send")
    @ResponseStatus(HttpStatus.CREATED)
    public String send(@RequestBody EmailModel email) {
        EmailService.send(email);
        return email.toString();
    }

    @PostMapping(path = "/default/{to}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmailModel defaultResponse(@PathVariable String to) {
        return EmailService.defaultResponse(to);
    }
}
