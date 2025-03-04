package com.emailService.model;

import lombok.Getter;
import lombok.Setter;

@Getter //Generates the default getter to all the non-static fields
public class EmailModel {

    private String to;
    private String title;
    private String body;
    private String from;
    private String scheduleAt;
    @Setter private String id;

    public EmailModel() {
    }

    public EmailModel(String title, String body, String from, String to, String id, String scheduleAt) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.to = to;
        this.id = id;
        this.scheduleAt = scheduleAt;
    }

    public EmailModel(String title, String body, String from, String to, String id) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public EmailModel(String title, String body, String from, String to) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {

        return "From: " + this.getFrom() + "\nTo: " + this.getTo() + "\nTitle: " + this.getTitle() + "\nBody: " + this.getBody() + "\nId: " + this.getId() + "\n";
    }

}
