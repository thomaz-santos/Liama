package com.emailService.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.json.JSONParser;

@Getter //Generates the default getter to all the non-static fields
public class EmailLiame {

    String to;
    String title;
    String body;
    String from;
    @Setter String id;

    public EmailLiame() {
    }

    public EmailLiame(String title, String body, String from, String to, String id) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public EmailLiame(String title, String body, String from, String to) {
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
