package com.emailService.domain;

public class EmailLiame {
    String title;
    String body;

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    String from;
    String to;

    public EmailLiame(String title, String body, String from, String to) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.to = to;
    }
}
